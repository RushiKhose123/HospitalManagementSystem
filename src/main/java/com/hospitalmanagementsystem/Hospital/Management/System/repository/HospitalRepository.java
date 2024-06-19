package com.hospitalmanagementsystem.Hospital.Management.System.repository;

import com.hospitalmanagementsystem.Hospital.Management.System.model.Hospital;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class HospitalRepository {
    // repository layer is that kind of layer that deals with your data
    HashMap<String, Hospital> hospitalDB = new HashMap<>();  // this hashmap is act like temporary database

    public HashMap<String, Hospital> getAllHospital(){
        return hospitalDB;
    }

    public void addHospital(String id, Hospital hospital){
        hospitalDB.put(id, hospital);
    }
}
