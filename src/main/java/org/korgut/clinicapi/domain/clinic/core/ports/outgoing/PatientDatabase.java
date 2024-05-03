package org.korgut.clinicapi.domain.clinic.core.ports.outgoing;

import org.korgut.clinicapi.domain.clinic.core.model.entities.Patient;
import org.korgut.clinicapi.domain.clinic.core.model.exceptions.DatabaseException;

public interface PatientDatabase {
    Patient createPatient(Patient patient) throws DatabaseException;
}
