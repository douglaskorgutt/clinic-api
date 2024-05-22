package org.korgut.clinicapi.domain.admin.core.model.commands.patient;

public record CreatePatientCommand(
        String commandId,
        String name,
        Float height,
        Float weight,
        Float bloodPressure,
        String healthInsuranceId,
        String cityId
) {
    public CreatePatientCommand {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be null or blank");
        }
        if (height == null) {
            throw new IllegalArgumentException("Height cannot be null");
        }
        if (weight == null) {
            throw new IllegalArgumentException("Weight cannot be null");
        }
        if (bloodPressure == null) {
            throw new IllegalArgumentException("Blood pressure cannot be null");
        }
        if (healthInsuranceId == null || healthInsuranceId.isBlank()) {
            throw new IllegalArgumentException("Health insurance ID cannot be null or blank");
        }

        if (cityId == null || cityId.isBlank()) {
            throw new IllegalArgumentException("City ID cannot be null or blank");
        }
    }
}
