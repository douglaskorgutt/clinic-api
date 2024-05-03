package org.korgut.clinicapi.domain.clinic.core.ports.incoming;

import org.korgut.clinicapi.domain.clinic.core.model.commands.CreateMedicationCommand;
import org.korgut.clinicapi.domain.clinic.core.model.exceptions.CrudException;
import org.korgut.clinicapi.domain.clinic.core.model.results.CommandResult;

public interface CreateMedication {
    CommandResult createMedication(CreateMedicationCommand createMedicationCommand) throws CrudException;
}
