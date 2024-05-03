package org.korgut.clinicapi.domain.admin.core.model.entities;

public record Doctor(String id, String name, String lastName, String specialty, HealthInsurance healthInsurance) {
}
