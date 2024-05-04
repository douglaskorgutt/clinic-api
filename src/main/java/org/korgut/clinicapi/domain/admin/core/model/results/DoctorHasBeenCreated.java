package org.korgut.clinicapi.domain.admin.core.model.results;

public class DoctorHasBeenCreated extends CommandResult {
    private final String doctorId;
    private final String name;

    public DoctorHasBeenCreated(String doctorId, String name, String commandId, String inboundCommandId) {
        this.commandId = commandId;
        this.inboundCommandId = inboundCommandId;
        this.doctorId = doctorId;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getDoctorId() {
        return doctorId;
    }
}
