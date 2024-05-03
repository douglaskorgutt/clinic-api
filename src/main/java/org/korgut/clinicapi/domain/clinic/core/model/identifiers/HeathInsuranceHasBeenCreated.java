package org.korgut.clinicapi.domain.clinic.core.model.identifiers;

public class HeathInsuranceHasBeenCreated extends CommandResult {
    private final String healthInsuranceName;

    public HeathInsuranceHasBeenCreated(final String id, final String healthInsuranceName) {
        this.id = id;
        this.healthInsuranceName = healthInsuranceName;
    }

    public String getHealthInsuranceName() {
        return healthInsuranceName;
    }
}
