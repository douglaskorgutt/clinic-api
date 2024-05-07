package org.korgut.clinicapi.domain.admin.core.ports.incoming;

import org.korgut.clinicapi.domain.admin.core.model.commands.FindDoctorCommand;
import org.korgut.clinicapi.domain.admin.core.model.exceptions.CrudException;
import org.korgut.clinicapi.domain.admin.core.model.results.CommandResult;

public interface FindDoctor {
    CommandResult execute(FindDoctorCommand findDoctorCommand) throws CrudException;
}
