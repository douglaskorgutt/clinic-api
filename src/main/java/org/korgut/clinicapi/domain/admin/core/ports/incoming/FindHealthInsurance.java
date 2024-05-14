package org.korgut.clinicapi.domain.admin.core.ports.incoming;

import org.korgut.clinicapi.domain.admin.core.model.commands.FindHealthInsuranceCommand;
import org.korgut.clinicapi.domain.admin.core.model.exceptions.CrudException;
import org.korgut.clinicapi.domain.admin.core.model.results.CommandResult;

public interface FindHealthInsurance {
    CommandResult execute(FindHealthInsuranceCommand command) throws CrudException;
}
