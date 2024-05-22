package org.korgut.clinicapi.domain.admin.core.ports.incoming.medication;


import org.korgut.clinicapi.domain.admin.core.model.commands.medication.CreateMedicationCommand;
import org.korgut.clinicapi.domain.admin.core.model.exceptions.CrudException;
import org.korgut.clinicapi.domain.admin.core.model.results.CommandResult;

public interface CreateMedication {
    CommandResult execute(CreateMedicationCommand createMedicationCommand) throws CrudException;
}
