package org.korgut.clinicapi.domain.admin.core.facades;


import org.korgut.clinicapi.domain.admin.core.model.commands.healthinsurance.CreateHealthInsuranceCommand;
import org.korgut.clinicapi.domain.admin.core.model.commands.healthinsurance.DeleteHealthInsuranceCommand;
import org.korgut.clinicapi.domain.admin.core.model.commands.healthinsurance.FindHealthInsuranceCommand;
import org.korgut.clinicapi.domain.admin.core.model.commands.healthinsurance.UpdateHealthInsuranceCommand;
import org.korgut.clinicapi.domain.admin.core.model.entities.HealthInsurance;
import org.korgut.clinicapi.domain.admin.core.model.enums.CrudOperation;
import org.korgut.clinicapi.domain.admin.core.model.exceptions.CrudException;
import org.korgut.clinicapi.domain.admin.core.model.exceptions.DatabaseException;
import org.korgut.clinicapi.domain.admin.core.model.exceptions.ValidationException;
import org.korgut.clinicapi.domain.admin.core.model.results.CommandResult;
import org.korgut.clinicapi.domain.admin.core.model.results.healthinsurance.HealthInsuranceDeleted;
import org.korgut.clinicapi.domain.admin.core.model.results.healthinsurance.HealthInsuranceHasBeenFound;
import org.korgut.clinicapi.domain.admin.core.model.results.healthinsurance.HealthInsuranceUpdated;
import org.korgut.clinicapi.domain.admin.core.model.results.healthinsurance.HeathInsuranceHasBeenCreated;
import org.korgut.clinicapi.domain.admin.core.ports.incoming.healthinsurance.CreateHealthInsurance;
import org.korgut.clinicapi.domain.admin.core.ports.incoming.healthinsurance.DeleteHealthInsurance;
import org.korgut.clinicapi.domain.admin.core.ports.incoming.healthinsurance.FindHealthInsurance;
import org.korgut.clinicapi.domain.admin.core.ports.incoming.healthinsurance.UpdateHealthInsurance;
import org.korgut.clinicapi.domain.admin.core.ports.outgoing.CooperativeValidator;
import org.korgut.clinicapi.domain.admin.core.ports.outgoing.HealthInsuranceDatabase;

import java.util.UUID;

public class HealthInsuranceFacade implements
        CreateHealthInsurance,
        FindHealthInsurance,
        UpdateHealthInsurance,
        DeleteHealthInsurance {
    private final HealthInsuranceDatabase healthInsuranceDatabase;
    private final CooperativeValidator cooperativeValidator;

    public HealthInsuranceFacade(
            HealthInsuranceDatabase healthInsuranceDatabase,
            CooperativeValidator cooperativeValidator) {
        this.healthInsuranceDatabase = healthInsuranceDatabase;
        this.cooperativeValidator = cooperativeValidator;
    }

    @Override
    public CommandResult execute(CreateHealthInsuranceCommand createHealthInsuranceCommand) throws CrudException {
        try {
            String cooperativeName = createHealthInsuranceCommand.cooperative();

            // Validate cooperative name
            this.cooperativeValidator.validate(cooperativeName);

            // Create health insurance record
            HealthInsurance healthInsurance = new HealthInsurance(
                    UUID.randomUUID().toString(),
                    createHealthInsuranceCommand.name(),
                    cooperativeName,
                    true
            );

            // Create health insurance db entry
            HealthInsurance created = healthInsuranceDatabase.createHealthInsurance(healthInsurance);

            return new HeathInsuranceHasBeenCreated(UUID.randomUUID().toString(), createHealthInsuranceCommand.commandId(), created.getName());
        } catch (DatabaseException | ValidationException e) {
            throw new CrudException(HealthInsurance.class, CrudOperation.CREATE, e.getMessage());
        }
    }

    @Override
    public CommandResult execute(FindHealthInsuranceCommand command) throws CrudException {
        try {
            // Find Health insurance by name
            HealthInsurance found = healthInsuranceDatabase
                    .findHealthInsuranceByName(command.healthInsuranceName())
                    // If not found, throw
                    .orElseThrow(() -> new CrudException(
                            HealthInsurance.class,
                            CrudOperation.READ,
                            "Health Insurance with name [" + command.healthInsuranceName() + "] was not found"
                    ));

            return new HealthInsuranceHasBeenFound(UUID.randomUUID().toString(), command.commandId(), found);
        } catch (DatabaseException e) {
            throw new CrudException(HealthInsurance.class, CrudOperation.READ, e.getMessage());
        }
    }

    @Override
    public CommandResult execute(UpdateHealthInsuranceCommand command) throws CrudException {
        try {
            // Find Health insurance by name
            healthInsuranceDatabase
                    .findHealthInsuranceByName(command.healthInsurance().getName())
                    // If not found, throw
                    .orElseThrow(() -> new CrudException(
                            HealthInsurance.class,
                            CrudOperation.READ,
                            "Health Insurance with name [" + command.healthInsurance().getName() + "] was not found"
                    ));

            HealthInsurance updated = healthInsuranceDatabase.updateHealthInsurance(command.healthInsurance());

            return new HealthInsuranceUpdated(command.commandId(), UUID.randomUUID().toString(), updated);
        } catch (DatabaseException e) {
            throw new CrudException(HealthInsurance.class, CrudOperation.UPDATE, e.getMessage());
        }
    }

    @Override
    public CommandResult execute(DeleteHealthInsuranceCommand command) throws CrudException {
        try {
            // Delete health insurance
            HealthInsurance deleted = healthInsuranceDatabase.deleteHealthInsuranceById(command.healthInsuranceId());

            return new HealthInsuranceDeleted(UUID.randomUUID().toString(), command.commandId(), deleted.getId());
        } catch (DatabaseException e) {
            throw new CrudException(HealthInsurance.class, CrudOperation.DELETE, e.getMessage());
        }
    }
}
