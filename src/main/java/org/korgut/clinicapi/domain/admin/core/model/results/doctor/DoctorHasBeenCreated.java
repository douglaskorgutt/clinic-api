package org.korgut.clinicapi.domain.admin.core.model.results.doctor;

import org.korgut.clinicapi.domain.admin.core.model.results.CommandResult;

public class DoctorHasBeenCreated extends CommandResult {
    private final String doctorId;
    private final String name;

    public DoctorHasBeenCreated(String doctorId, String name, String commandId, String inboundCommandId) {
        super(commandId, inboundCommandId);
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
