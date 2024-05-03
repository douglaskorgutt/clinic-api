package org.korgut.clinicapi.domain.clinic.core.ports.incoming;

import org.korgut.clinicapi.domain.clinic.core.model.commands.CreateHealthInsuranceCommand;
import org.korgut.clinicapi.domain.clinic.core.model.exceptions.CrudException;
import org.korgut.clinicapi.domain.clinic.core.model.identifiers.Identifier;

public interface CreateHealthInsurance {
    Identifier createHealthInsurance(CreateHealthInsuranceCommand createHealthInsuranceCommand) throws CrudException;
}
