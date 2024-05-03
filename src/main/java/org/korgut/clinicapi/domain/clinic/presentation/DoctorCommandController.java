package org.korgut.clinicapi.domain.clinic.presentation;


import org.korgut.clinicapi.domain.clinic.core.ports.incoming.CreateDoctor;

public class DoctorCommandController {
    private final CreateDoctor createDoctor;

    public DoctorCommandController(CreateDoctor createDoctor) {
        this.createDoctor = createDoctor;
    }
}
