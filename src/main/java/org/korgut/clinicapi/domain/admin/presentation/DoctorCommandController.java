package org.korgut.clinicapi.domain.admin.presentation;


import org.korgut.clinicapi.domain.admin.core.ports.incoming.CreateDoctor;

public class DoctorCommandController {
    private final CreateDoctor createDoctor;

    public DoctorCommandController(CreateDoctor createDoctor) {
        this.createDoctor = createDoctor;
    }
}
