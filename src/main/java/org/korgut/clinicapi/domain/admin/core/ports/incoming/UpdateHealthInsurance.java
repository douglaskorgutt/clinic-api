package org.korgut.clinicapi.domain.admin.core.ports.incoming;

import org.korgut.clinicapi.domain.admin.core.model.commands.UpdateHealthInsuranceCommand;
import org.korgut.clinicapi.domain.admin.core.model.exceptions.CrudException;
import org.korgut.clinicapi.domain.admin.core.model.results.CommandResult;

public interface UpdateHealthInsurance {
    CommandResult execute(UpdateHealthInsuranceCommand command) throws CrudException;
}
