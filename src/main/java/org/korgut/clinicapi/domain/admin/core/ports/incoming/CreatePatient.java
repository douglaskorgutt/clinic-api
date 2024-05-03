package org.korgut.clinicapi.domain.admin.core.ports.incoming;


import org.korgut.clinicapi.domain.admin.core.model.commands.CreatePatientCommand;
import org.korgut.clinicapi.domain.admin.core.model.exceptions.CrudException;
import org.korgut.clinicapi.domain.admin.core.model.results.CommandResult;

public interface CreatePatient {
    CommandResult createPatient(CreatePatientCommand createPatientCommand) throws CrudException;
}
