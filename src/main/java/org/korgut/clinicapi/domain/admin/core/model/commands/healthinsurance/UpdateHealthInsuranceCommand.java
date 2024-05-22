package org.korgut.clinicapi.domain.admin.core.model.commands.healthinsurance;

import org.korgut.clinicapi.domain.admin.core.model.entities.HealthInsurance;

public record UpdateHealthInsuranceCommand(String commandId, HealthInsurance healthInsurance) {
    public UpdateHealthInsuranceCommand {
        if (commandId == null || commandId.isBlank())
            throw new IllegalArgumentException("Command id cannot be null or empty");

        if (healthInsurance == null)
            throw new IllegalArgumentException("Health insurance cannot be null");
    }
}
