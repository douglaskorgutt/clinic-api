package org.korgut.clinicapi.domain.clinic.core.model.results;

public class MedicationHasBeenCreated extends CommandResult {
    private final String name;
    private final String id;
    public MedicationHasBeenCreated(String name, String id) {
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
