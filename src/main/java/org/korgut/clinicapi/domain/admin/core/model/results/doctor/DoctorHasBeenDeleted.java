package org.korgut.clinicapi.domain.admin.core.model.results.doctor;

import org.korgut.clinicapi.domain.admin.core.model.results.CommandResult;

public class DoctorHasBeenDeleted extends CommandResult {
    private String doctorId;
    private String doctorName;

    public DoctorHasBeenDeleted(String commandId, String inboundCommandId, String doctorId, String doctorName) {
        super(commandId, inboundCommandId);
        this.doctorId = doctorId;
        this.doctorName = doctorName;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }
}
