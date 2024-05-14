package org.korgut.clinicapi.domain.admin.core.model.commands;

public record FindHealthInsuranceCommand(String commandId, String healthInsuranceName) {
    public FindHealthInsuranceCommand {
        if (commandId == null || commandId.isEmpty())
            throw new IllegalArgumentException("Command id cannot be null or empty");

        if (healthInsuranceName == null || healthInsuranceName.isEmpty())
            throw new IllegalArgumentException("Health insurance name cannot be null or empty");
    }
}
