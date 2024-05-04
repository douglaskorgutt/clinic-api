package org.korgut.clinicapi.domain.admin.presentation.dto.outbound;

public record CreateDoctorOutboundDto(String commandId, String doctorId, String doctorName) {
    public CreateDoctorOutboundDto {
        if (commandId == null || commandId.isBlank())
            throw new IllegalArgumentException("Command ID cannot be null or blank");

        if (doctorId == null || doctorId.isBlank())
            throw new IllegalArgumentException("Doctor ID cannot be null or blank");

        if (doctorName == null || doctorName.isBlank())
            throw new IllegalArgumentException("Doctor name cannot be null or blank");
    }
}
