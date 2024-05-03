package org.korgut.clinicapi.domain.clinic.core.ports.outgoing;

import org.korgut.clinicapi.domain.clinic.core.model.entities.Medication;
import org.korgut.clinicapi.domain.clinic.core.model.exceptions.DatabaseException;

public interface MedicationDatabase {
    Medication createMedication(Medication medication) throws DatabaseException;
}
