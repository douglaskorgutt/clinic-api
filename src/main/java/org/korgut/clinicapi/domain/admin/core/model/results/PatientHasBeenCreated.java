package org.korgut.clinicapi.domain.admin.core.model.results;

public class PatientHasBeenCreated extends CommandResult {
    private final String name;

    public PatientHasBeenCreated(String commandId, String inboundCommandId, String name) {
        super(commandId, inboundCommandId);
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
