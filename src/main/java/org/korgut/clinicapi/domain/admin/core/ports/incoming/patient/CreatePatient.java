package org.korgut.clinicapi.domain.admin.core.ports.incoming.patient;


import org.korgut.clinicapi.domain.admin.core.model.commands.patient.CreatePatientCommand;
import org.korgut.clinicapi.domain.admin.core.model.exceptions.CrudException;
import org.korgut.clinicapi.domain.admin.core.model.results.CommandResult;

public interface CreatePatient {
    CommandResult execute(CreatePatientCommand createPatientCommand) throws CrudException;
}
