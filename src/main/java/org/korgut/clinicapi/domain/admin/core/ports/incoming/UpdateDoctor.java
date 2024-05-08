package org.korgut.clinicapi.domain.admin.core.ports.incoming;

import org.korgut.clinicapi.domain.admin.core.model.commands.UpdateDoctorCommand;
import org.korgut.clinicapi.domain.admin.core.model.exceptions.CrudException;
import org.korgut.clinicapi.domain.admin.core.model.results.CommandResult;

public interface UpdateDoctor {
    CommandResult execute(UpdateDoctorCommand command) throws CrudException;
}
