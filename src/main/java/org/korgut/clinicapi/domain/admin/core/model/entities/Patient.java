package org.korgut.clinicapi.domain.admin.core.model.entities;

public record Patient (
        String id,
        String name,
        Float height,
        Float weight,
        Float bloodPressure,
        HealthInsurance healthInsurance,
        City city
){ }
