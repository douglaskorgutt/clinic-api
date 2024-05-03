package org.korgut.clinicapi.domain.admin.core.model.commands;

public record CreateHealthInsuranceCommand(String name, String cooperative) {
    public CreateHealthInsuranceCommand {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be null or blank");
        }
        if (cooperative == null || cooperative.isBlank()) {
            throw new IllegalArgumentException("Cooperative cannot be null or blank");
        }
    }
}
