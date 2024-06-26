package org.korgut.clinicapi.domain.admin.core.model.exceptions;

import org.korgut.clinicapi.domain.admin.core.model.enums.CrudOperation;

public class CrudException extends Exception {
    public CrudException(Class<?> entity, CrudOperation operation, String message) {
        super("Could not execute operation [" + operation + "] " +
                "upon entity [" + entity.getSimpleName() + "]. Error: " + message);
    }
}
