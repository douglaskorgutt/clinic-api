package org.korgut.clinicapi.domain.admin.core.model.exceptions;

public class ValidationException extends Exception {
    public ValidationException(String message) {
        super(message);
    }
}
