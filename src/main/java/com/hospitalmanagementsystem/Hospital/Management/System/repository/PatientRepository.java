package com.hospitalmanagementsystem.Hospital.Management.System.repository;

import com.hospitalmanagementsystem.Hospital.Management.System.model.Patient;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class PatientRepository {

    // Patient id vs patient Object
    HashMap<String, Patient> patientDB = new HashMap<>();

    public void registerPatient(Patient patient){
        String patientId = patient.getPatientID() + "";
        patientDB.put(patientId, patient);
    }
}
