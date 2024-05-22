package org.korgut.clinicapi.domain.admin.core.model.commands.doctor;

public record DeleteDoctorCommand (String commandId, String doctorName){
    public DeleteDoctorCommand {
        if (commandId == null || commandId.isBlank())
            throw new IllegalArgumentException("Command ID cannot be null or empty");
        if (doctorName == null || doctorName.isBlank())
            throw new IllegalArgumentException("Doctor name cannot be null or empty");
    }
}
