package org.korgut.clinicapi.domain.admin.core.model.results.healthinsurance;

import org.korgut.clinicapi.domain.admin.core.model.results.CommandResult;

public class HealthInsuranceDeleted extends CommandResult {
    private final String healthInsuranceId;

    public HealthInsuranceDeleted(String commandId, String inboundCommandId, String healthInsuranceId) {
        super(commandId, inboundCommandId);
        this.healthInsuranceId = healthInsuranceId;
    }

    public String getHealthInsuranceId() {
        return healthInsuranceId;
    }
}
