package org.korgut.clinicapi.domain.clinic.core.ports.outgoing;

import org.korgut.clinicapi.domain.clinic.core.model.entities.Medication;
import org.korgut.clinicapi.domain.clinic.core.model.exceptions.ValidationException;

public interface MedicationValidator {

    boolean validate(Medication medication) throws ValidationException;
}
