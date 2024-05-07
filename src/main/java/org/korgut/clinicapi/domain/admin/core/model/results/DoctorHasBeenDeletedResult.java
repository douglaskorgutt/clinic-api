package org.korgut.clinicapi.domain.admin.core.model.results;

public class DoctorHasBeenDeletedResult extends CommandResult {
    private String doctorId;
    private String doctorName;

    public DoctorHasBeenDeletedResult(String commandId, String inboundCommandId, String doctorId, String doctorName) {
        this.commandId = commandId;
        this.inboundCommandId = inboundCommandId;
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
