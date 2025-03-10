package com.BloodBank.Model;

import java.time.LocalDate;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

@Entity
@Table(name = "donors")
public class Donor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    private String bloodGroup;
    private String gender;
    private String contactNumber;
    private String address;
    private String email;
    private Double unit;
    
    
 

	private Boolean splitBlood;
    private Double quantity;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate lastDonation;

    private Double plasmaAmount;
    private Double rbcAmount;
    private Double plateletsAmount;

    // No-argument constructor
    public Donor() {
    }

    // Parameterized constructor
    public Donor(Long id, String name, String bloodGroup, String gender, String contactNumber, String address,
                 String email, Double unit, Boolean splitBlood, LocalDate lastDonation, 
                 Double plasmaAmount, Double rbcAmount, Double plateletsAmount) {
        this.id = id;
        this.name = name;
        this.bloodGroup = bloodGroup;
        this.gender = gender;
        this.contactNumber = contactNumber;
        this.address = address;
        this.email = email;
        this.unit = unit;
        this.splitBlood = splitBlood;
        this.lastDonation = lastDonation;
        this.plasmaAmount = plasmaAmount;
        this.rbcAmount = rbcAmount;
        this.plateletsAmount = plateletsAmount;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {  this.bloodGroup = bloodGroup;  }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getAddress() {
        return address;
    }
    public Double getQuantity() {
 		return quantity;
 	}

 	public void setQuantity(Double quantity) {
 		this.quantity = quantity;
 	}

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public LocalDate getLastDonation() {
        return lastDonation;
    }

    public void setLastDonation(LocalDate lastDonation) {
        this.lastDonation = lastDonation;
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

    // toString() method
    @Override
    public String toString() {
        return "Donor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", bloodGroup='" + bloodGroup + '\'' +
                ", gender='" + gender + '\'' +
                ", contactNumber='" + contactNumber + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", unit=" + unit +
                ", splitBlood=" + splitBlood +
                ", lastDonation=" + lastDonation +
                ", plasmaAmount=" + plasmaAmount +
                ", rbcAmount=" + rbcAmount +
                ", plateletsAmount=" + plateletsAmount +
                '}';
    }
    
}
