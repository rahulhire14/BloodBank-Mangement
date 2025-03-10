package com.BloodBank.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.BloodBank.Model.BloodStock;
import com.BloodBank.Model.Donor;

@Repository
public interface DonorRepository extends JpaRepository<Donor, Long> {
	   List<Donor> findByBloodGroup(String bloodGroup);
	   List<Donor> findByName(String name);
	   Optional<Donor> findById(Long id);
	
}
