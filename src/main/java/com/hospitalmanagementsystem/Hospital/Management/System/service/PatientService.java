package com.hospitalmanagementsystem.Hospital.Management.System.service;

import com.hospitalmanagementsystem.Hospital.Management.System.model.Hospital;
import com.hospitalmanagementsystem.Hospital.Management.System.model.Patient;
import com.hospitalmanagementsystem.Hospital.Management.System.repository.HospitalRepository;
import com.hospitalmanagementsystem.Hospital.Management.System.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class PatientService {


    PatientRepository patientRepository = new PatientRepository();

    HospitalRepository hospitalRepository = new HospitalRepository();

    public Hospital registerPatient(Patient patient){
        patientRepository.registerPatient(patient);
        // we need to assign patient that hospital which is having maximum number of beds so
        // patientService requires hospitalRepository

        HashMap<String, Hospital> allHospitals = hospitalRepository.getAllHospital();

        int maxBed = Integer.MIN_VALUE;
        Hospital maxBedHospital = null;

        for(String key : allHospitals.keySet()){
            Hospital hospital = allHospitals.get(key);
            int bedCount = hospital.totalBeds;
            if(bedCount > maxBed){
                maxBed = bedCount;
                maxBedHospital = hospital;
            }
        }
        return maxBedHospital;
    }
}
