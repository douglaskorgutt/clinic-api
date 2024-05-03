package org.korgut.clinicapi.domain.admin.core.ports.incoming;


import org.korgut.clinicapi.domain.admin.core.model.commands.CreateMedicationCommand;
import org.korgut.clinicapi.domain.admin.core.model.exceptions.CrudException;
import org.korgut.clinicapi.domain.admin.core.model.results.CommandResult;

public interface CreateMedication {
    CommandResult createMedication(CreateMedicationCommand createMedicationCommand) throws CrudException;
}
