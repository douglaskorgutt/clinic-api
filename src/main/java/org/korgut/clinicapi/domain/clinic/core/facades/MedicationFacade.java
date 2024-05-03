package org.korgut.clinicapi.domain.clinic.core.facades;

import org.korgut.clinicapi.domain.clinic.core.model.commands.CreateMedicationCommand;
import org.korgut.clinicapi.domain.clinic.core.model.entities.Medication;
import org.korgut.clinicapi.domain.clinic.core.model.enums.CrudOperation;
import org.korgut.clinicapi.domain.clinic.core.model.exceptions.CrudException;
import org.korgut.clinicapi.domain.clinic.core.model.exceptions.DatabaseException;
import org.korgut.clinicapi.domain.clinic.core.model.exceptions.ValidationException;
import org.korgut.clinicapi.domain.clinic.core.model.results.CommandResult;
import org.korgut.clinicapi.domain.clinic.core.model.results.MedicationHasBeenCreated;
import org.korgut.clinicapi.domain.clinic.core.ports.incoming.CreateMedication;
import org.korgut.clinicapi.domain.clinic.core.ports.outgoing.MedicationDatabase;
import org.korgut.clinicapi.domain.clinic.core.ports.outgoing.MedicationValidator;

import java.util.UUID;

public class MedicationFacade implements CreateMedication {

    private final MedicationDatabase medicationDatabase;
    private final MedicationValidator medicationValidator;

    public MedicationFacade(MedicationDatabase medicationDatabase, MedicationValidator medicationValidator) {
        this.medicationDatabase = medicationDatabase;
        this.medicationValidator = medicationValidator;
    }

    @Override
    public CommandResult createMedication(CreateMedicationCommand createMedicationCommand) throws CrudException {
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

            return new MedicationHasBeenCreated(created.id(), created.name());
        } catch (DatabaseException | ValidationException e) {
            throw new CrudException(Medication.class, CrudOperation.CREATE, e.getMessage());
        }
    }
}
