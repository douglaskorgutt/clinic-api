package org.korgut.clinicapi.domain.admin.core.model.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
public class HealthInsurance {

    @Id
    private String id;
    private String name;
    private String cooperative;
    private Boolean isValid;

    public HealthInsurance() {
    }

    public HealthInsurance(String id, String name, String cooperative, Boolean isValid) {
        this.id = id;
        this.name = name;
        this.cooperative = cooperative;
        this.isValid = isValid;
    }

    // Getters
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCooperative() {
        return cooperative;
    }

    public Boolean getIsValid() {
        return isValid;
    }

    // Setters
    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCooperative(String cooperative) {
        this.cooperative = cooperative;
    }

    public void setIsValid(Boolean isValid) {
        this.isValid = isValid;
    }

    // Optional: Override toString, equals, and hashCode methods
    @Override
    public String toString() {
        return "HealthInsurance{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", cooperative='" + cooperative + '\'' +
                ", isValid=" + isValid +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HealthInsurance that = (HealthInsurance) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(cooperative, that.cooperative) &&
                Objects.equals(isValid, that.isValid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, cooperative, isValid);
    }
}
