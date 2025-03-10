package com.BloodBank.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.BloodBank.Model.Seeker;
import com.BloodBank.services.SeekerServices;

@RestController
@RequestMapping("/api/seeker")
@CrossOrigin(origins = "http://localhost:5173")
public class SeekerController {
    
    @Autowired 
    private SeekerServices seekerServices;

    @PostMapping("/request")
    public ResponseEntity<String> requestBlood(@RequestBody Seeker seeker) {
        String status = seekerServices.requestBloodGroup(seeker);
        return ResponseEntity.ok(status);
    } 
}
