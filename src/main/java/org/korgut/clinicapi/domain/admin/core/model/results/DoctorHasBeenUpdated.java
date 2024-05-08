package org.korgut.clinicapi.domain.admin.core.model.results;

import org.korgut.clinicapi.domain.admin.core.model.entities.Doctor;

public class DoctorHasBeenUpdated extends CommandResult{
    private final Doctor doctor;
    public DoctorHasBeenUpdated(String commandId, String inboundCommandId, Doctor doctor) {
        this.commandId = commandId;
        this.inboundCommandId = inboundCommandId;
        this.doctor = doctor;
    }

    public Doctor getDoctor() {
        return this.doctor;
    }
}
