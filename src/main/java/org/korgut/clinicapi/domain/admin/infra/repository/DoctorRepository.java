package org.korgut.clinicapi.domain.admin.infra.repository;


import org.korgut.clinicapi.domain.admin.core.model.entities.Doctor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends CrudRepository<Doctor, String> {
}
