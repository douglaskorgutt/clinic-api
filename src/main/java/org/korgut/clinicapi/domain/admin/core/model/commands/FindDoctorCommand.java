package org.korgut.clinicapi.domain.admin.core.model.commands;

public record FindDoctorCommand(
        String name,
        String id
) { }