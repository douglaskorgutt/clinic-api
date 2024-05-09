package org.korgut.clinicapi.domain.admin.core.model.entities;

public class Patient {
    private String id;
    private String name;
    private Float height;
    private Float weight;
    private Float bloodPressure;
    private HealthInsurance healthInsurance;
    private City city;
    public Patient(String id, String name, Float height, Float weight, Float bloodPressure, HealthInsurance healthInsurance, City city) {
        this.id = id;
        this.name = name;
        this.height = height;
        this.weight = weight;
        this.bloodPressure = bloodPressure;
        this.healthInsurance = healthInsurance;
        this.city = city;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getHeight() {
        return height;
    }

    public void setHeight(Float height) {
        this.height = height;
    }

    public Float getWeight() {
        return weight;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }

    public Float getBloodPressure() {
        return bloodPressure;
    }

    public void setBloodPressure(Float bloodPressure) {
        this.bloodPressure = bloodPressure;
    }

    public HealthInsurance getHealthInsurance() {
        return healthInsurance;
    }

    public void setHealthInsurance(HealthInsurance healthInsurance) {
        this.healthInsurance = healthInsurance;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }
}
