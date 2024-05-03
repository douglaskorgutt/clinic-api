package org.korgut.clinicapi.domain.clinic.core.ports.outgoing;

import org.korgut.clinicapi.domain.clinic.core.model.entities.Doctor;
import org.korgut.clinicapi.domain.clinic.core.model.exceptions.DatabaseException;

public interface DoctorDatabase {
    Doctor createDoctor(Doctor doctor) throws DatabaseException;
}
