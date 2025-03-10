package com.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication(scanBasePackages = "com.bloodbank")
@EntityScan("com.bloodbank.model")
@EnableJpaRepositories("com.bloodbank.repository")
public class BloodBankApplication {
	  public static void main(String[] args) {
	        SpringApplication.run(BloodBankApplication.class, args);
	        
	    }
}

