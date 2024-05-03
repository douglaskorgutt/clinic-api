package org.korgut.clinicapi.domain.admin.core.ports.incoming;


import org.korgut.clinicapi.domain.admin.core.model.commands.CreateDoctorCommand;
import org.korgut.clinicapi.domain.admin.core.model.exceptions.CrudException;
import org.korgut.clinicapi.domain.admin.core.model.results.CommandResult;

public interface CreateDoctor {
    CommandResult createDoctor(CreateDoctorCommand createDoctorCommand) throws CrudException;
}
