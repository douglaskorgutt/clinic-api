package org.korgut.clinicapi.domain.admin.core.model.commands;

import org.korgut.clinicapi.domain.admin.core.model.entities.Doctor;

public record UpdateDoctorCommand (String commandId, Doctor doctor){
    public UpdateDoctorCommand {
        if (commandId == null || commandId.isBlank())
            throw new IllegalArgumentException("Command ID cannot be nor or empty");

        if (doctor == null)
            throw new IllegalArgumentException("Doctor cannot be null");
    }
}
