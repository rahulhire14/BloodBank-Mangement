package com.BloodBank.services;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;

import com.BloodBank.Model.BloodStock;
import com.BloodBank.Model.Donor;
import com.BloodBank.Repository.BloodStockRepository;
import com.BloodBank.Repository.DonorRepository;

@Service
public class DonorServices {

    @Autowired
    private DonorRepository donorRepository;
    
    @Autowired
    private BloodStockRepository bloodStockRepository;
    
    public boolean canDonate(Donor donor) {
        LocalDate lastDonation = donor.getLastDonation();
        LocalDate today = LocalDate.now();
        return lastDonation == null || ChronoUnit.MONTHS.between(lastDonation, today) >= 3;
    }

    public Donor getDonorById(Long id) {
        return donorRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Donor with ID " + id + " not found!"));
    }

    @Transactional
    public Donor addDonor(Donor donor) {
        if (!canDonate(donor)) {
            throw new RuntimeException("Donor is not eligible to donate. They must wait at least 3 months from the last donation.");
        }

        if (donor.getSplitBlood() != null && donor.getSplitBlood()) {
            Double quantity = donor.getQuantity();
            donor.setRbcAmount(quantity * 0.4);
            donor.setPlasmaAmount(quantity * 0.55);
            donor.setPlateletsAmount(quantity * 0.05);
        } else {
            donor.setRbcAmount(null);
            donor.setPlasmaAmount(null);
            donor.setPlateletsAmount(null);
        }

        donor.setLastDonation(LocalDate.now());
        
        // Save donor first
        Donor savedDonor = donorRepository.save(donor);
        System.out.println("Donor saved: " + savedDonor.getId());

        // Update blood stock with donation details
        updateBloodStock(savedDonor);

        return savedDonor;
    }

    @Transactional
    private void updateBloodStock(Donor donor) {
        System.out.println("Updating Blood Stock for Blood Group: " + donor.getBloodGroup());

        BloodStock bloodStock = new BloodStock();
        bloodStock.setBloodGroup(donor.getBloodGroup());
        bloodStock.setQuantity(donor.getQuantity());
        bloodStock.setUnit(donor.getUnit());
        bloodStock.setPlasmaAmount(donor.getQuantity() * 0.55);
        bloodStock.setRbcAmount(donor.getQuantity() * 0.4);
        bloodStock.setPlateletsAmount(donor.getQuantity() * 0.05);

        BloodStock savedStock = bloodStockRepository.save(bloodStock);
        System.out.println("Blood stock updated with ID: " + savedStock.getId());
    }

    @Transactional
    public Donor updateDonor(Long id, Donor updatedDonor) {
        Optional<Donor> existingDonor = donorRepository.findById(id);
        if (existingDonor.isPresent()) {
            Donor donor = existingDonor.get();
            donor.setName(updatedDonor.getName());
            donor.setAddress(updatedDonor.getAddress());
            donor.setContactNumber(updatedDonor.getContactNumber());
            donor.setGender(updatedDonor.getGender());
            donor.setEmail(updatedDonor.getEmail());
            return donorRepository.save(donor);
        } else {
            return null;
        }
    }
}
