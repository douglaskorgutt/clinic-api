package org.korgut.clinicapi.domain.admin.core.model.commands.doctor;

public record CreateDoctorCommand(
        String commandId,
        String firstName,
        String lastName,
        String specialty,
        String healthInsuranceId) {
    public CreateDoctorCommand {
        if (commandId == null || commandId.isBlank())
            throw new IllegalArgumentException("Command ID cannot be null or blank");

        if (firstName == null || firstName.isBlank()) {
            throw new IllegalArgumentException("First name cannot be null or blank");
        }
        if (lastName == null || lastName.isBlank()) {
            throw new IllegalArgumentException("Last name cannot be null or blank");
        }
        if (specialty == null || specialty.isBlank()) {
            throw new IllegalArgumentException("Specialty cannot be null or blank");
        }
        if (healthInsuranceId == null || healthInsuranceId.isBlank()) {
            throw new IllegalArgumentException("Health insurance ID cannot be null or blank");
        }
    }
}