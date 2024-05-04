package org.korgut.clinicapi.domain.admin.presentation.dto.inbound;

public record CreateDoctorInboundDto(
        String commandId,
        String firstName,
        String lastName,
        String specialty,
        String healthInsuranceId) {
    public CreateDoctorInboundDto {
        if (commandId == null || commandId.isBlank())
            throw new IllegalArgumentException("Command ID cannot be null or empty");

        if (firstName == null || firstName.isBlank())
            throw new IllegalArgumentException("First name cannot be null or empty");

        if (lastName == null || lastName.isBlank())
            throw new IllegalArgumentException("Last name cannot be null or empty");

        if (specialty == null || specialty.isBlank())
            throw new IllegalArgumentException("Specialty cannot be null or empty");

        if (healthInsuranceId == null || healthInsuranceId.isBlank())
            throw new IllegalArgumentException("Health insurance cannot be null or empty");
    }
}
