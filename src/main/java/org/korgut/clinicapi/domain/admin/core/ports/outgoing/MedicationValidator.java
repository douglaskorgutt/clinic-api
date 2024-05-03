package org.korgut.clinicapi.domain.admin.core.ports.outgoing;

import org.korgut.clinicapi.domain.admin.core.model.entities.Medication;
import org.korgut.clinicapi.domain.admin.core.model.exceptions.ValidationException;

public interface MedicationValidator {

    boolean validate(Medication medication) throws ValidationException;
}
