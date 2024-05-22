package org.korgut.clinicapi.domain.admin.core.ports.incoming.doctor;


import org.korgut.clinicapi.domain.admin.core.model.commands.doctor.CreateDoctorCommand;
import org.korgut.clinicapi.domain.admin.core.model.exceptions.CrudException;
import org.korgut.clinicapi.domain.admin.core.model.results.CommandResult;

public interface CreateDoctor {
    CommandResult execute(CreateDoctorCommand createDoctorCommand) throws CrudException;
}
