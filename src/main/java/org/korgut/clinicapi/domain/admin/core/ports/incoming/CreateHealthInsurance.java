package org.korgut.clinicapi.domain.admin.core.ports.incoming;


import org.korgut.clinicapi.domain.admin.core.model.commands.CreateHealthInsuranceCommand;
import org.korgut.clinicapi.domain.admin.core.model.exceptions.CrudException;
import org.korgut.clinicapi.domain.admin.core.model.results.CommandResult;

public interface CreateHealthInsurance {
    CommandResult createHealthInsurance(CreateHealthInsuranceCommand createHealthInsuranceCommand) throws CrudException;
}
