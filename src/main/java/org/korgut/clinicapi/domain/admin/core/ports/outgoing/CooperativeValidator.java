package org.korgut.clinicapi.domain.admin.core.ports.outgoing;


import org.korgut.clinicapi.domain.admin.core.model.exceptions.ValidationException;

public interface CooperativeValidator {
    void validate(String cooperativeName) throws ValidationException;
}
