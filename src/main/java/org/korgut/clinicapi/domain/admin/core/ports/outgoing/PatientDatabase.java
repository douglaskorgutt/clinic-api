package org.korgut.clinicapi.domain.admin.core.ports.outgoing;


import org.korgut.clinicapi.domain.admin.core.model.entities.Patient;
import org.korgut.clinicapi.domain.admin.core.model.exceptions.DatabaseException;

public interface PatientDatabase {
    Patient createPatient(Patient patient) throws DatabaseException;
}
