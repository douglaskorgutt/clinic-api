package org.korgut.clinicapi.domain.clinic.core.model.commands;

public record CreatePatientCommand(
        String id,
        String name,

        Float height,

        Float weight,

        Float bloodPressure,

        String healthInsuranceId
) {
}
