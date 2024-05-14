package org.korgut.clinicapi.domain.admin.core.facades;


import org.korgut.clinicapi.domain.admin.core.model.commands.CreateHealthInsuranceCommand;
import org.korgut.clinicapi.domain.admin.core.model.commands.FindHealthInsuranceCommand;
import org.korgut.clinicapi.domain.admin.core.model.entities.HealthInsurance;
import org.korgut.clinicapi.domain.admin.core.model.enums.CrudOperation;
import org.korgut.clinicapi.domain.admin.core.model.exceptions.CrudException;
import org.korgut.clinicapi.domain.admin.core.model.exceptions.DatabaseException;
import org.korgut.clinicapi.domain.admin.core.model.exceptions.ValidationException;
import org.korgut.clinicapi.domain.admin.core.model.results.CommandResult;
import org.korgut.clinicapi.domain.admin.core.model.results.HealthInsuranceHasBeenFound;
import org.korgut.clinicapi.domain.admin.core.model.results.HeathInsuranceHasBeenCreated;
import org.korgut.clinicapi.domain.admin.core.ports.incoming.CreateHealthInsurance;
import org.korgut.clinicapi.domain.admin.core.ports.incoming.FindHealthInsurance;
import org.korgut.clinicapi.domain.admin.core.ports.outgoing.CooperativeValidator;
import org.korgut.clinicapi.domain.admin.core.ports.outgoing.HealthInsuranceDatabase;

import java.util.UUID;

public class HealthInsuranceFacade implements CreateHealthInsurance, FindHealthInsurance {
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

            return new HeathInsuranceHasBeenCreated(created.getId(), created.getName());
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
}
