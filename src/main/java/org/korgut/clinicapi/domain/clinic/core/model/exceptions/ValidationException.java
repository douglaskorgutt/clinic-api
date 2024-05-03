package org.korgut.clinicapi.domain.clinic.core.model.exceptions;

public class ValidationException extends Exception {
    public ValidationException(String message) {
        super(message);
    }
}
