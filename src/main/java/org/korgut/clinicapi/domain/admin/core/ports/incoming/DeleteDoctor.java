package org.korgut.clinicapi.domain.admin.core.ports.incoming;

import org.korgut.clinicapi.domain.admin.core.model.commands.DeleteDoctorCommand;
import org.korgut.clinicapi.domain.admin.core.model.exceptions.CrudException;
import org.korgut.clinicapi.domain.admin.core.model.results.CommandResult;

public interface DeleteDoctor {
    CommandResult execute(DeleteDoctorCommand command) throws CrudException;
}
