package org.korgut.clinicapi.domain.admin.core.ports.incoming.doctor;

import org.korgut.clinicapi.domain.admin.core.model.commands.doctor.FindDoctorCommand;
import org.korgut.clinicapi.domain.admin.core.model.exceptions.CrudException;
import org.korgut.clinicapi.domain.admin.core.model.results.CommandResult;

public interface FindDoctor {
    CommandResult execute(FindDoctorCommand findDoctorCommand) throws CrudException;
}
