package org.korgut.clinicapi.domain.clinic.core.ports.incoming;

import org.korgut.clinicapi.domain.clinic.core.model.commands.CreateDoctorCommand;
import org.korgut.clinicapi.domain.clinic.core.model.exceptions.CrudException;
import org.korgut.clinicapi.domain.clinic.core.model.results.CommandResult;

public interface CreateDoctor {
    CommandResult createDoctor(CreateDoctorCommand createDoctorCommand) throws CrudException;
}
