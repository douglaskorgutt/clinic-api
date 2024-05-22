package org.korgut.clinicapi.domain.admin.core.model.results.doctor;

import org.korgut.clinicapi.domain.admin.core.model.entities.Doctor;
import org.korgut.clinicapi.domain.admin.core.model.results.CommandResult;

public class DoctorHasBeenUpdated extends CommandResult {
    private final Doctor doctor;

    public DoctorHasBeenUpdated(String commandId, String inboundCommandId, Doctor doctor) {
        super(commandId, inboundCommandId);
        this.doctor = doctor;
    }

    public Doctor getDoctor() {
        return this.doctor;
    }
}
