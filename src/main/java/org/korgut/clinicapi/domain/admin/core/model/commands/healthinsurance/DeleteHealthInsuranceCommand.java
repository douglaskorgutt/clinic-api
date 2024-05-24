package org.korgut.clinicapi.domain.admin.core.model.commands.healthinsurance;

public record DeleteHealthInsuranceCommand(String commandId, String healthInsuranceId){
    public DeleteHealthInsuranceCommand {
        if (commandId == null || commandId.isBlank())
            throw new IllegalArgumentException("Command Id cannot be null or empty");

        if (healthInsuranceId == null || healthInsuranceId.isBlank())
            throw new IllegalArgumentException("Health insurance id cannot be null or empty");
    }
}
