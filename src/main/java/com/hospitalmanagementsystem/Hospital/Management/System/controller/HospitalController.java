package com.hospitalmanagementsystem.Hospital.Management.System.controller;

import com.hospitalmanagementsystem.Hospital.Management.System.model.Hospital;
import com.hospitalmanagementsystem.Hospital.Management.System.service.HospitalService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HospitalController {
    // in your controller you need to specify url

    // user can see all hospital details
    // it will be nothing but all hospital details
    // user can add new hospital into the system
    // so we want to create url such that when user will hit that url user will be able to see all hospital details


    HospitalService hospitalService = new HospitalService();
    @GetMapping("/api/hospitals")
    public List<Hospital> getAllHospital(){
        // to get list of all hospitals we need to write loigic
        // logic needs to be written in service layer
        List<Hospital> hospitals = hospitalService.getAllHospital();
        return hospitals;
    }

    int count = 0;
    @PostMapping("/api/addhospital")
    public String addHospital(){
        Hospital hospital = new Hospital();
        hospital.name = "Som";
        hospital.id = count;
        String id = count + "";
        count++;
        hospitalService.addHospital(id, hospital);
        return "Hospital object got added";
        // service layer -> we are calling service layer to add this hospital object to our system
    }


    @GetMapping("/api/sayhello")
    public String sayHello(){
        return "hello";
    }

    @GetMapping("/api/saybye")
    public String sayBye(){
        return "bye";
    }

    @PostMapping("/api/createpost")
    public String createPost(){
        return "Create post";
    }

    // @RestController: this is a annotation that will help springboot to understand that this is a controller class
}
