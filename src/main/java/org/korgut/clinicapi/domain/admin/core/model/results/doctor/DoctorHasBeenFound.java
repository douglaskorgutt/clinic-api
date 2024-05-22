package org.korgut.clinicapi.domain.admin.core.model.results.doctor;

import org.korgut.clinicapi.domain.admin.core.model.entities.Doctor;
import org.korgut.clinicapi.domain.admin.core.model.results.CommandResult;

public class DoctorHasBeenFound extends CommandResult {
    private final Doctor doctor;

    public DoctorHasBeenFound(String id, String inboundCommandId, Doctor doctor) {
        this.commandId = id;
        this.inboundCommandId = inboundCommandId;
        this.doctor = doctor;
    }

    public Doctor getDoctor() {
        return this.doctor;
    }
}
