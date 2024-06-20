package com.hospitalmanagementsystem.Hospital.Management.System.model;

public class Patient {
    private int patientID;
    private String name;
    private int age;
    private String gender;
    private String disease;

    public Patient(int patientID, String name, int age, String gender, String disease) {
        this.patientID = patientID;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.disease = disease;
    }

    public int getPatientID() {
        return patientID;
    }

    public void setPatientID(int patientID) {
        this.patientID = patientID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDisease() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }
}
