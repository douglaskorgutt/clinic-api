package org.korgut.clinicapi.domain.admin.core.ports.outgoing;


import org.korgut.clinicapi.domain.admin.core.model.entities.Doctor;
import org.korgut.clinicapi.domain.admin.core.model.exceptions.DatabaseException;

public interface DoctorDatabase {
    Doctor createDoctor(Doctor doctor) throws DatabaseException;
}
