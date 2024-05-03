package org.korgut.clinicapi.domain.clinic.core.ports.incoming;

import org.korgut.clinicapi.domain.clinic.core.model.commands.CreateDoctorCommand;
import org.korgut.clinicapi.domain.clinic.core.model.exceptions.CrudException;
import org.korgut.clinicapi.domain.clinic.core.model.identifiers.Identifier;

public interface CreateDoctor {
    Identifier createDoctor(CreateDoctorCommand createDoctorCommand) throws CrudException;
}
