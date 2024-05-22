package org.korgut.clinicapi.domain.admin.core.model.results.healthinsurance;

import org.korgut.clinicapi.domain.admin.core.model.results.CommandResult;

public class HeathInsuranceHasBeenCreated extends CommandResult {
    private final String name;

    public HeathInsuranceHasBeenCreated(final String id, final String healthInsuranceName) {
        this.commandId = id;
        this.name = healthInsuranceName;
    }

    public String getHealthInsuranceName() {
        return name;
    }
}
