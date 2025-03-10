package com.BloodBank.Model;


import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@Entity
@Table

public class BloodStock {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	
	
	
	
	  private String bloodGroup;
	  private Double unit;
	  private Double quantity;
	    private Boolean splitBlood;

	    private Double plasmaAmount;
	    private Double rbcAmount;
	    private Double plateletsAmount;
	    private LocalDate dateOfAddition;
		public String getBloodGroup() {
			return bloodGroup;
		}
		public void setBloodGroup(String bloodGroup) {
			this.bloodGroup = bloodGroup;
		}
		public Double getUnit() {
			return unit;
		}
		public void setUnit(Double unit) {
			this.unit = unit;
		}
		public Boolean getSplitBlood() {
			return splitBlood;
		}
		public void setSplitBlood(Boolean splitBlood) {
			this.splitBlood = splitBlood;
		}
		public Double getPlasmaAmount() {
			return plasmaAmount;
		}
		public void setPlasmaAmount(Double plasmaAmount) {
			this.plasmaAmount = plasmaAmount;
		}
		public Double getRbcAmount() {
			return rbcAmount;
		}
		public void setRbcAmount(Double rbcAmount) {
			this.rbcAmount = rbcAmount;
		}
		public Double getPlateletsAmount() {
			return plateletsAmount;
		}
		public void setPlateletsAmount(Double plateletsAmount) {
			this.plateletsAmount = plateletsAmount;
		}
		public BloodStock(String bloodGroup, Double unit, Boolean splitBlood, Double plasmaAmount, Double rbcAmount,
				Double plateletsAmount) {
			super();
			this.bloodGroup = bloodGroup;
			this.unit = unit;
			this.splitBlood = splitBlood;
			this.plasmaAmount = plasmaAmount;
			this.rbcAmount = rbcAmount;
			this.plateletsAmount = plateletsAmount;
		}
		public BloodStock() {
			
		
		}
		public Double getQuantity() {
			return quantity;
		}
		public void setQuantity(Double quantity) {
			this.quantity = quantity;
		}
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public LocalDate getDateOfAddition() {
			return dateOfAddition;
		}
		public void setDateOfAddition(LocalDate dateOfAddition) {
			this.dateOfAddition = dateOfAddition;
		}
    
	    
	    
	    
}
