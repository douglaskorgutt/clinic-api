package org.korgut.clinicapi.domain.admin.core.model.commands.healthinsurance;

public record CreateHealthInsuranceCommand(String commandId, String name, String cooperative) {
    public CreateHealthInsuranceCommand {
        if (commandId == null || commandId.isBlank())
            throw new IllegalArgumentException("CommandId cannot be null or empty");

        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be null or blank");
        }
        if (cooperative == null || cooperative.isBlank()) {
            throw new IllegalArgumentException("Cooperative cannot be null or blank");
        }
    }
}
