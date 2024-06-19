package com.hospitalmanagementsystem.Hospital.Management.System.service;

import com.hospitalmanagementsystem.Hospital.Management.System.model.Hospital;
import com.hospitalmanagementsystem.Hospital.Management.System.repository.HospitalRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class HospitalService {

    // to make spring understand this is service class we used @service annotation
    // in service class we write all our logic

    // as hospital service needs hospital repository thats why we have created one instance over object
    // of hospital repository inside hospital service
    // we have injected the dependency of hospital repository inside hospital service

    HospitalRepository hospitalRepository = new HospitalRepository();
    public List<Hospital> getAllHospital(){
        // you needs hospitals data
        // service layer need to call repository layer
        HashMap<String, Hospital> hospitalDB = hospitalRepository.getAllHospital();
        List<Hospital> allHospitals = new ArrayList<>();
        for(String hospitalID : hospitalDB.keySet()){
            Hospital hospital = hospitalDB.get(hospitalID);
            allHospitals.add(hospital);
        }
        return allHospitals;
    }

    public void addHospital(String id, Hospital hospital){
        // service layer wants to save this object in the system
        // service layer will call repository layer to save this object
        hospitalRepository.addHospital(id, hospital);
    }
}
