package org.korgut.clinicapi.domain.admin.core.model.results.healthinsurance;

import org.korgut.clinicapi.domain.admin.core.model.entities.HealthInsurance;
import org.korgut.clinicapi.domain.admin.core.model.results.CommandResult;

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
