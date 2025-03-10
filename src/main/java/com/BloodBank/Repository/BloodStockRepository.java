package com.BloodBank.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.BloodBank.Model.BloodStock;

public interface BloodStockRepository extends JpaRepository<BloodStock, Long> {

	
	
	List<BloodStock> findByBloodGroup(String bloodGroup);

}
