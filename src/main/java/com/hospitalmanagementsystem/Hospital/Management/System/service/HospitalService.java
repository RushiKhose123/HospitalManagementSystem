package com.hospitalmanagementsystem.Hospital.Management.System.service;

import com.hospitalmanagementsystem.Hospital.Management.System.model.Hospital;
import com.hospitalmanagementsystem.Hospital.Management.System.repository.HospitalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class HospitalService {

    // on our application when patient will come he will try to admit himself
    // when he wants to admit himself in the portal so, he will provide his details
    // like age, name, gender, disease
    // so we will try to assign one hospital to that patient
    // logic for assign hospital to the patient will be whichever hospital is having
    // max no. of beds you will assign that hospital to patient

    // we need to develop one endpoint such that a particular patient can register himself on our portal



    // to make spring understand this is service class we used @service annotation
    // in service class we write all our logic

    // as hospital service needs hospital repository thats why we have created one instance over object
    // of hospital repository inside hospital service
    // we have injected the dependency of hospital repository inside hospital service

    @Autowired
    HospitalRepository hospitalRepository;
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

    public Hospital getHospitalDetailById(int id){
        // service layer need to call repository layer
        return hospitalRepository.getHospitalDetailById(id);
    }
}
