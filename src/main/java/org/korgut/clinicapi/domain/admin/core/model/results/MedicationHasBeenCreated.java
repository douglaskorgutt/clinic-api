package org.korgut.clinicapi.domain.admin.core.model.results;

public class MedicationHasBeenCreated extends CommandResult {
    private final String name;
    private final String id;

    public MedicationHasBeenCreated(String commandId, String inboundCommandId, String name, String id) {
        super(commandId, inboundCommandId);
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }
}
