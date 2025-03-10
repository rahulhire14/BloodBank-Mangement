package com.BloodBank.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.BloodBank.Model.BloodStock;
import com.BloodBank.Model.Donor;
import com.BloodBank.Repository.BloodStockRepository;
import com.BloodBank.Repository.DonorRepository;
import com.BloodBank.services.BloodStockServices;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/api/bloodStock")
@CrossOrigin(origins = "http://localhost:5173")
public class BloodStockController {
	 @Autowired
	 private BloodStockServices bloodStockServices;
	   @Autowired
	   DonorRepository donorRepository;
	       @Autowired
	       private BloodStockRepository bloodStockRepository;
	@GetMapping
	 public ResponseEntity<List<BloodStock>>getAllBloodStock () {
      List<BloodStock>bloodStocks=bloodStockServices.getAllBloodStock();
      return ResponseEntity.ok(bloodStocks);
    }
	@GetMapping("/{bloodGroup}")
	public ResponseEntity<List<BloodStock>> getByBloodGroup(@PathVariable String bloodGroup) {
	    List<BloodStock> bloodStockList =bloodStockServices.getByBloodGroup(bloodGroup);

	    if (bloodStockList.isEmpty()) {
	        return ResponseEntity.notFound().build(); 
	    }

	    return ResponseEntity.ok(bloodStockList); 
	}

	
	@PostMapping("/add")
	public ResponseEntity<BloodStock>addBloodStock(@RequestBody BloodStock bloodStock){
	BloodStock bloodStock1 = bloodStockServices.addBloodStock(bloodStock);
	return ResponseEntity.ok(bloodStock1);
		
		
		
	}
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Donor>>getDonorById (@PathVariable Long id){
		Optional<Donor> donors = bloodStockServices.getDonorById(id);
		return ResponseEntity.ok(donors);
		
	
	}
	@DeleteMapping("/delete/{id}")
	public void deleteDonor(@PathVariable Long id) {
		bloodStockServices.deleteDonor(id);
		
	}
		
	
	@GetMapping("/{name}")
	public ResponseEntity<List<Donor>>getDonorByName(@RequestParam String name) {
		List<Donor> donors = bloodStockServices.getDonorByName(name);
		return ResponseEntity.ok(donors);
	}
	
	
	
}
