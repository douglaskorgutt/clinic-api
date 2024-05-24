package org.korgut.clinicapi.domain.admin.core.ports.incoming.healthinsurance;

import org.korgut.clinicapi.domain.admin.core.model.commands.healthinsurance.DeleteHealthInsuranceCommand;
import org.korgut.clinicapi.domain.admin.core.model.exceptions.CrudException;
import org.korgut.clinicapi.domain.admin.core.model.results.CommandResult;

public interface DeleteHealthInsurance {
    CommandResult execute(DeleteHealthInsuranceCommand command) throws CrudException;
}
