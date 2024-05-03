package org.korgut.clinicapi.domain.admin.core.model.results;

public class PatientHasBeenCreated extends CommandResult {
    private final String name;

    public PatientHasBeenCreated(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
