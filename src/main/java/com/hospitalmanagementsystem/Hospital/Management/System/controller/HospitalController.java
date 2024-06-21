package com.hospitalmanagementsystem.Hospital.Management.System.controller;

import com.hospitalmanagementsystem.Hospital.Management.System.model.Hospital;
import com.hospitalmanagementsystem.Hospital.Management.System.service.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HospitalController {
    // after question mark if you are seeing any key value pair. then we call those key value pair as query
    // parameter or request parameter

    // in your controller you need to specify url

    // user can see all hospital details
    // it will be nothing but all hospital details
    // user can add new hospital into the system
    // so we want to create url such that when user will hit that url user will be able to see all hospital details


    @Autowired
    HospitalService hospitalService;
    @GetMapping("/api/hospitals")
    public List<Hospital> getAllHospital(){
        // to get list of all hospitals we need to write loigic
        // logic needs to be written in service layer
        List<Hospital> hospitals = hospitalService.getAllHospital();
        return hospitals;
    }

    // in post method user provide some kind of information and that information will get saved into system
    // how user provides information
    // user provides information in the form of jason
    // Springboot will receive json object or jason payload or body which we are passing
    // when we are hitting endpoint or url
    // Springboot will convert that json object into hospital class object

    int count = 0;
    @PostMapping("/api/addhospital")
    public String addHospital(@RequestBody Hospital hospital){
       String id = hospital.id + "";
        hospitalService.addHospital(id, hospital);
        return "Hospital object got added";
        // service layer -> we are calling service layer to add this hospital object to our system
    }

    // I want to develop one endpoint which client will hit then client will able to see specific hospital detail

    @GetMapping("/api/hospital")
    public Hospital getSpecificHospitalDetail(@RequestParam int hospitalId){
        // controller will ask service to provide hospital details on the basis of hospitalId
        return hospitalService.getHospitalDetailById(hospitalId);
    }

    @GetMapping("/api/hospital/{hospitalId}/detail")
    public Hospital getSpecificHospitalDetailsByUsingPathVariable(@PathVariable int hospitalId){
        return hospitalService.getHospitalDetailById(hospitalId);
    }


    // @RestController: this is a annotation that will help springboot to understand that this is a controller class
}
