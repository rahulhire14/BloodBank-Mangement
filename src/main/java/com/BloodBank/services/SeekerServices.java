package com.BloodBank.services;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BloodBank.Model.BloodComponent;
import com.BloodBank.Model.BloodStock;
import com.BloodBank.Model.Donor;
import com.BloodBank.Model.RequestStatus;
import com.BloodBank.Model.Seeker;
import com.BloodBank.Repository.BloodStockRepository;
import com.BloodBank.Repository.DonorRepository;
import com.BloodBank.Repository.SeekerRepository;

@Service
public class SeekerServices {

    @Autowired
    private SeekerRepository seekerRepository;

    @Autowired
   private BloodStockRepository bloodStockRepository;

    private RequestStatus requestStatus;

    public RequestStatus getRequestStatus() {
        return this.requestStatus;
    }
    
    public String requestBloodGroup(Seeker seeker) {
    	List<BloodStock>bloodStocks=bloodStockRepository.findByBloodGroup(seeker.getBloodGroup());
    	if  (bloodStocks.isEmpty()) {
    		seeker.setStatus(requestStatus.REJECTED);
    		seekerRepository.save(seeker);
            return "Rejected - No blood stock available for the requested blood group";
    	}
    	double requiredRemaningQuantity = seeker.getRequiredQuantity();
    	boolean requestFullfilled= false;   
    for	(BloodStock bloodStock : bloodStocks) {
    	double availableQuantity = 0.0;
    	  
    	switch (seeker.getComponent()) {
    	
		case WHOLE_BLOOD:
			availableQuantity = bloodStock.getQuantity();
			break;
		case PLASMA:
			availableQuantity = bloodStock.getPlasmaAmount();
			break;
		case RBC:
			availableQuantity = bloodStock.getRbcAmount();
			break;
		case PLATELETS:
			  availableQuantity = bloodStock.getPlateletsAmount();
			break;
		default:
			 return "Invalid blood component requested";
		}
    	if (availableQuantity > 0) {
    		double usedQuantity = Math.min(requiredRemaningQuantity, availableQuantity);
    		
    		
    				switch  (seeker.getComponent()) {
    				case WHOLE_BLOOD:
    					bloodStock.setQuantity(bloodStock.getQuantity()- usedQuantity);
    					break;
    				case PLASMA:
    					bloodStock.setQuantity(bloodStock.getPlasmaAmount()- usedQuantity);
    					break;
    				case RBC:
    					bloodStock.setQuantity(bloodStock.getRbcAmount()- usedQuantity);
    					break;
    				case PLATELETS:
    					bloodStock.setQuantity(bloodStock.getPlateletsAmount()-usedQuantity );
    					break;
    				}

                    bloodStockRepository.save(bloodStock);
                    requiredRemaningQuantity -= usedQuantity;

                    if (requiredRemaningQuantity <= 0) {
                    	requestFullfilled = true;
                        break;
                    }}}
   

    seeker.setStatus(requestFullfilled ? RequestStatus.APPROVED : RequestStatus.REJECTED);
    seekerRepository.save(seeker);

    return requestFullfilled ? "Approved" : "Rejected - Not enough units available";
    }
private void deleteBloodRecord(BloodStock bloodStock) {
	if ((bloodStock.getQuantity()==0 || bloodStock.getQuantity()==null)&&
	(bloodStock.getPlasmaAmount()==0 || bloodStock.getPlasmaAmount()==null)&& 
	(bloodStock.getPlateletsAmount()==0 || bloodStock.getPlateletsAmount()==null)&&
	(bloodStock.getRbcAmount()==0 || bloodStock.getRbcAmount()==null)
	    )
	{
		bloodStockRepository.delete(bloodStock);
	}
	    
			{
		
	}
}    
}
