package org.korgut.clinicapi.domain.clinic.core.model.entities;

public record Doctor(String id, String name, String lastName, String specialty, HealthInsurance healthInsurance) {
}
