package org.korgut.clinicapi.domain.clinic.core.ports.outgoing;

import org.korgut.clinicapi.domain.clinic.core.model.exceptions.ValidationException;

public interface CooperativeValidator {
    void validate(String cooperativeName) throws ValidationException;
}
