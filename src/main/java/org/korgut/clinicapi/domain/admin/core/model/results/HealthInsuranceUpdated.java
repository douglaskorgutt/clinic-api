package org.korgut.clinicapi.domain.admin.core.model.results;

import org.korgut.clinicapi.domain.admin.core.model.entities.HealthInsurance;

public class HealthInsuranceUpdated extends CommandResult {
    private final HealthInsurance healthInsurance;

    public HealthInsuranceUpdated(String commandId, String inboundCommandId, HealthInsurance healthInsurance) {
        super(commandId, inboundCommandId);
        this.healthInsurance = healthInsurance;
    }

    public HealthInsurance getHealthInsurance() {
        return healthInsurance;
    }
}
