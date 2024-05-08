package org.korgut.clinicapi.domain.admin.core.ports.outgoing;


import org.korgut.clinicapi.domain.admin.core.model.entities.Doctor;
import org.korgut.clinicapi.domain.admin.core.model.exceptions.DatabaseException;

import java.util.Optional;

public interface DoctorDatabase {
    Doctor createDoctor(Doctor doctor) throws DatabaseException;

    Optional<Doctor> findDoctorByName(String name) throws DatabaseException;

    Doctor deleteDoctor(String id) throws DatabaseException;

    Doctor updateDoctor(Doctor doctor) throws DatabaseException;
}
