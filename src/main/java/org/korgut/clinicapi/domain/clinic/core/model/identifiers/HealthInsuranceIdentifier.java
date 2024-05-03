package org.korgut.clinicapi.domain.clinic.core.model.identifiers;

public class HealthInsuranceIdentifier extends Identifier {
    private final String healthInsuranceName;

    public HealthInsuranceIdentifier(final String id, final String healthInsuranceName) {
        this.id = id;
        this.healthInsuranceName = healthInsuranceName;
    }

    public String getHealthInsuranceName() {
        return healthInsuranceName;
    }
}
