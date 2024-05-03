package org.korgut.clinicapi.domain.clinic.core.model.results;

public class HeathInsuranceHasBeenCreated extends CommandResult {
    private final String name;

    public HeathInsuranceHasBeenCreated(final String id, final String healthInsuranceName) {
        this.id = id;
        this.name = healthInsuranceName;
    }

    public String getHealthInsuranceName() {
        return name;
    }
}
