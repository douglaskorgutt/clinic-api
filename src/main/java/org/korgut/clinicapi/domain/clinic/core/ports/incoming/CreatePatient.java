package org.korgut.clinicapi.domain.clinic.core.ports.incoming;

import org.korgut.clinicapi.domain.clinic.core.model.commands.CreatePatientCommand;
import org.korgut.clinicapi.domain.clinic.core.model.exceptions.CrudException;
import org.korgut.clinicapi.domain.clinic.core.model.results.CommandResult;

public interface CreatePatient {
    CommandResult createPatient(CreatePatientCommand createPatientCommand) throws CrudException;
}
