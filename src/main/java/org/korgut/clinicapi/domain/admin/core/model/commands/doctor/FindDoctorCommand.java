package org.korgut.clinicapi.domain.admin.core.model.commands.doctor;

public record FindDoctorCommand(
        String name,
        String id
) { }