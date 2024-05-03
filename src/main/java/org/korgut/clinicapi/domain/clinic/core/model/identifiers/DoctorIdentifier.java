package org.korgut.clinicapi.domain.clinic.core.model.identifiers;

public class DoctorIdentifier extends Identifier {
    private final String name;

    public DoctorIdentifier(String id, String name) {
        this.id = id;
        this.name = name;
    }
}
