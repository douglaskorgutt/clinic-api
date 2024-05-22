package org.korgut.clinicapi.domain.admin.core.facades;


import org.korgut.clinicapi.domain.admin.core.model.commands.medication.CreateMedicationCommand;
import org.korgut.clinicapi.domain.admin.core.model.entities.Medication;
import org.korgut.clinicapi.domain.admin.core.model.enums.CrudOperation;
import org.korgut.clinicapi.domain.admin.core.model.exceptions.CrudException;
import org.korgut.clinicapi.domain.admin.core.model.exceptions.DatabaseException;
import org.korgut.clinicapi.domain.admin.core.model.exceptions.ValidationException;
import org.korgut.clinicapi.domain.admin.core.model.results.CommandResult;
import org.korgut.clinicapi.domain.admin.core.model.results.MedicationHasBeenCreated;
import org.korgut.clinicapi.domain.admin.core.ports.incoming.medication.CreateMedication;
import org.korgut.clinicapi.domain.admin.core.ports.outgoing.MedicationDatabase;
import org.korgut.clinicapi.domain.admin.core.ports.outgoing.MedicationValidator;

import java.util.UUID;

public class MedicationFacade implements CreateMedication {

    private final MedicationDatabase medicationDatabase;
    private final MedicationValidator medicationValidator;

    public MedicationFacade(MedicationDatabase medicationDatabase, MedicationValidator medicationValidator) {
        this.medicationDatabase = medicationDatabase;
        this.medicationValidator = medicationValidator;
    }

    @Override
    public CommandResult execute(CreateMedicationCommand createMedicationCommand) throws CrudException {
        try {
            // Create medication
            Medication medication = new Medication(
                    UUID.randomUUID().toString(),
                    createMedicationCommand.name(),
                    createMedicationCommand.serialNumber()
            );

            // Check if medication is valid
            medicationValidator.validate(medication);

            // If so, create medication
            Medication created = medicationDatabase.createMedication(medication);

            return new MedicationHasBeenCreated(
                    UUID.randomUUID().toString(),
                    createMedicationCommand.commandId(),
                    created.getId(),
                    created.getName()
            );
        } catch (DatabaseException | ValidationException e) {
            throw new CrudException(Medication.class, CrudOperation.CREATE, e.getMessage());
        }
    }
}
