package org.korgut.clinicapi.domain.clinic.infra.repository;

import org.korgut.clinicapi.domain.clinic.core.model.entities.HealthInsurance;
import org.springframework.data.repository.CrudRepository;

public interface HealthInsuranceRepository extends CrudRepository<HealthInsurance, String> {
}
