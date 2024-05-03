package org.korgut.clinicapi.domain.clinic.core.model.commands;

public record CreateDoctorCommand(String firstName, String lastName, String specialty, String healthInsuranceId) {
    public CreateDoctorCommand {
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