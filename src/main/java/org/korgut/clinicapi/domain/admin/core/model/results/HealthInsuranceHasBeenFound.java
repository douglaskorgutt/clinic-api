package org.korgut.clinicapi.domain.admin.core.model.results;

import org.korgut.clinicapi.domain.admin.core.model.entities.HealthInsurance;

public class HealthInsuranceHasBeenFound extends CommandResult {

    private final HealthInsurance healthInsurance;

    public HealthInsuranceHasBeenFound(String commandId, String inboundCommandId, HealthInsurance healthInsurance) {
        super(commandId, inboundCommandId);
        this.healthInsurance = healthInsurance;
    }

    public HealthInsurance getHealthInsurance() {
        return healthInsurance;
    }
}
