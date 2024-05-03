package org.korgut.clinicapi.domain.clinic.core.ports.incoming;

import org.korgut.clinicapi.domain.clinic.core.model.commands.CreateHealthInsuranceCommand;
import org.korgut.clinicapi.domain.clinic.core.model.exceptions.CrudException;
import org.korgut.clinicapi.domain.clinic.core.model.results.CommandResult;

public interface CreateHealthInsurance {
    CommandResult createHealthInsurance(CreateHealthInsuranceCommand createHealthInsuranceCommand) throws CrudException;
}
