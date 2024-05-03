package org.korgut.clinicapi.domain.admin.infra.repository;


import org.korgut.clinicapi.domain.admin.core.model.entities.HealthInsurance;
import org.springframework.data.repository.CrudRepository;

public interface HealthInsuranceRepository extends CrudRepository<HealthInsurance, String> {
}
