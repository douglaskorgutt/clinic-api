package org.korgut.clinicapi.domain.admin.infra.repository;


import org.korgut.clinicapi.domain.admin.core.model.entities.HealthInsurance;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HealthInsuranceRepository extends CrudRepository<HealthInsurance, String> {
}
