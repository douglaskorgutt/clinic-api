package org.korgut.clinicapi.domain.admin.core.ports.outgoing;


import org.korgut.clinicapi.domain.admin.core.model.entities.Medication;
import org.korgut.clinicapi.domain.admin.core.model.exceptions.DatabaseException;

public interface MedicationDatabase {
    Medication createMedication(Medication medication) throws DatabaseException;
}
