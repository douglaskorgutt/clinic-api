package org.korgut.clinicapi.domain.admin.core.model.entities;

public class City {
    private String id;
    private String name;
    private Integer numberOfCitizens;

    public City(String id, String name, Integer numberOfCitizens) {
        this.id = id;
        this.name = name;
        this.numberOfCitizens = numberOfCitizens;
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

    public Integer getNumberOfCitizens() {
        return numberOfCitizens;
    }

    public void setNumberOfCitizens(Integer numberOfCitizens) {
        this.numberOfCitizens = numberOfCitizens;
    }
}
