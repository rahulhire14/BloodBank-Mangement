package com.BloodBank.services;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.BloodBank.Model.BloodStock;
import com.BloodBank.Model.Donor;
import com.BloodBank.Repository.BloodStockRepository;
import com.BloodBank.Repository.DonorRepository;

import jakarta.transaction.Transactional;

@Service
public class BloodStockServices {

	
@Autowired
private BloodStockRepository bloodStockRepository;
 
@Autowired
private DonorRepository donorRepository;
       
   public List<BloodStock> getAllBloodStock(){
	   return bloodStockRepository.findAll();
   }
   public List<BloodStock> getByBloodGroup(String bloodGroup) {
	    return bloodStockRepository.findByBloodGroup(bloodGroup);
	}
	   
   
   public BloodStock addBloodStock(BloodStock bloodStock) {
	   if (bloodStock.getSplitBlood() != null && bloodStock.getSplitBlood()) {
           Double quantity = bloodStock.getQuantity();
           bloodStock.setRbcAmount(quantity * 0.4);     
           bloodStock.setPlasmaAmount(quantity * 0.55);   
           bloodStock.setPlateletsAmount(quantity * 0.05);
       } else {
    	   bloodStock.setRbcAmount(null);
    	   bloodStock.setPlasmaAmount(null);
    	   bloodStock.setPlateletsAmount(null);
       }
	   return bloodStockRepository.save(bloodStock);
   }
   private void deleteRbc(BloodStock bloodStock) {
	   LocalDate dateOfAddition = bloodStock.getDateOfAddition();
	   LocalDate today = LocalDate.now();
	   if(ChronoUnit.DAYS.between(dateOfAddition, today)>44) {
		   bloodStock.setRbcAmount(null);
	   }     } 
	   
 public Optional<Donor> getDonorById(Long id) {
	 return donorRepository.findById(id);
			 }   
 
public List<Donor> getDonorByName(String name){
	return donorRepository.findByName(name);
}
public void  deleteDonor (Long id) {
	if (donorRepository.existsById(id)) {
		  donorRepository.deleteById(id);
	}
}
   @Transactional
   public void registerDonor(Donor donor) {
       donorRepository.save(donor);

     
       List<BloodStock> existingStock = bloodStockRepository.findByBloodGroup(donor.getBloodGroup());

       BloodStock stock;

       if (!existingStock.isEmpty()) { 
         
           stock = existingStock.get(0);
           stock.setQuantity(stock.getQuantity() + donor.getQuantity());
           stock.setPlasmaAmount(stock.getPlasmaAmount() + donor.getPlasmaAmount());
           stock.setRbcAmount(stock.getRbcAmount() + donor.getRbcAmount());
           stock.setPlateletsAmount(stock.getPlateletsAmount() + donor.getPlateletsAmount());
       } else {
   
           stock = new BloodStock();
           stock.setBloodGroup(donor.getBloodGroup()); 
           stock.setUnit(donor.getUnit());
           stock.setPlasmaAmount(donor.getPlasmaAmount());
           stock.setRbcAmount(donor.getRbcAmount());
           stock.setPlateletsAmount(donor.getPlateletsAmount());
       }

       bloodStockRepository.save(stock);
   }
   }