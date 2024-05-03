package org.korgut.clinicapi.domain.clinic.infra.repository;

import org.korgut.clinicapi.domain.clinic.core.model.entities.Doctor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends CrudRepository<Doctor, String> {
}
