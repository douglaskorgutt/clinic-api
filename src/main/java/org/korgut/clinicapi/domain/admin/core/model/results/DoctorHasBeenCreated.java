package org.korgut.clinicapi.domain.admin.core.model.results;

public class DoctorHasBeenCreated extends CommandResult {
    private final String name;

    public DoctorHasBeenCreated(String id, String name) {
        this.id = id;
        this.name = name;
    }
}
