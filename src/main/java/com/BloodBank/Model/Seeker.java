package com.BloodBank.Model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "seekers")
public class Seeker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String address;
    private String bloodGroup;
    private String hospitalName;
    private String gender;
    private Double unitRequired;

    @Enumerated(EnumType.STRING)
    private BloodComponent component; // Enum for blood components

    private Integer age;
    private String contactNumber;
    private String reason;
    private Boolean emergencyCase;
    private  Double requiredQuantity;
    @Enumerated(EnumType.STRING)
    @JsonProperty("requestStatus")
    private RequestStatus status; // Enum for status

    private LocalDateTime createdAt = LocalDateTime.now(); // Auto timestamp

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getBloodGroup() { return bloodGroup; }
    public void setBloodGroup(String bloodGroup) { this.bloodGroup = bloodGroup; }

    public String getHospitalName() { return hospitalName; }
    public void setHospitalName(String hospitalName) { this.hospitalName = hospitalName; }

    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }

    public Double getUnitRequired() { return unitRequired; }
    public void setUnitRequired(Double unitRequired) { this.unitRequired = unitRequired; }

    public BloodComponent getComponent() { return component; }
    public void setComponent(BloodComponent component) { this.component = component; }

    public Integer getAge() { return age; }
    public void setAge(Integer age) { this.age = age; }

    public String getContactNumber() { return contactNumber; }
    public void setContactNumber(String contactNumber) { this.contactNumber = contactNumber; }

    public String getReason() { return reason; }
    public void setReason(String reason) { this.reason = reason; }

    public Boolean getEmergencyCase() { return emergencyCase; }
    public void setEmergencyCase(Boolean emergencyCase) { this.emergencyCase = emergencyCase; }

    public RequestStatus getStatus() { return status; }
    public void setStatus(RequestStatus status) { this.status = status; }

    public LocalDateTime getCreatedAt() { return createdAt; }
	public Double getRequiredQuantity() {
		return requiredQuantity;
	}
	public void setRequiredQuantity(Double requiredQuantity) {
		this.requiredQuantity = requiredQuantity;
	}
}
