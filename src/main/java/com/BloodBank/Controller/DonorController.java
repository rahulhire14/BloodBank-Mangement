package com.BloodBank.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.BloodBank.Model.Donor;
import com.BloodBank.services.DonorServices;

@RestController
@RequestMapping("/api/donor")
@CrossOrigin(origins = "http://localhost:5173")
public class DonorController {

    @Autowired
    private DonorServices donorservices;
    
    @GetMapping("/{id}")
    public ResponseEntity<Donor> getDonorById(@PathVariable Long id) {
        Donor donor = donorservices.getDonorById(id);
        return ResponseEntity.ok(donor);
    }

 
    @PostMapping("/add")
    public ResponseEntity<Donor> addDonor(@RequestBody Donor donor) {
        Donor savedDonor = donorservices.addDonor(donor);
        return ResponseEntity.ok(savedDonor);
    }

    
    @PutMapping("/update/{id}")
    public ResponseEntity<Donor> updateDonor(@PathVariable Long id, @RequestBody Donor donor) {
        Donor updatedDonor = donorservices.updateDonor(id, donor);
        return ResponseEntity.ok(updatedDonor);
    }
}
