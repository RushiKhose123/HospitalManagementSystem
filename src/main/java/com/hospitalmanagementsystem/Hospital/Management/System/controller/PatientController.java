package com.hospitalmanagementsystem.Hospital.Management.System.controller;

import com.hospitalmanagementsystem.Hospital.Management.System.model.Hospital;
import com.hospitalmanagementsystem.Hospital.Management.System.model.Patient;
import com.hospitalmanagementsystem.Hospital.Management.System.service.PatientService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PatientController {


    PatientService patientService = new PatientService();

    // when a particular patient try to register itself then the particular patient get saved into our system and
    // at the same time get associated with hospital which is having max beds
    // so when we are hitting this endpoint it will return hospital object in which patient got registered

    @PostMapping("/api/patient/register")
    public Hospital registerPatient(@RequestBody Patient patient){
        // patient controller will call patient service
        Hospital hospital = patientService.registerPatient(patient);
        return hospital;
    }

}
