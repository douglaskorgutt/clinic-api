package org.korgut.clinicapi.domain.admin.core.model.results.healthinsurance;

import org.korgut.clinicapi.domain.admin.core.model.results.CommandResult;

public class HeathInsuranceHasBeenCreated extends CommandResult {
    private final String name;

    public HeathInsuranceHasBeenCreated(String commandId, String inboundCommandId, String healthInsuranceName) {
        super(commandId, inboundCommandId);
        this.name = healthInsuranceName;
    }

    public String getHealthInsuranceName() {
        return name;
    }
}
