package org.korgut.clinicapi.domain.admin.core.ports.incoming.doctor;

import org.korgut.clinicapi.domain.admin.core.model.commands.doctor.UpdateDoctorCommand;
import org.korgut.clinicapi.domain.admin.core.model.exceptions.CrudException;
import org.korgut.clinicapi.domain.admin.core.model.results.CommandResult;

public interface UpdateDoctor {
    CommandResult execute(UpdateDoctorCommand command) throws CrudException;
}
