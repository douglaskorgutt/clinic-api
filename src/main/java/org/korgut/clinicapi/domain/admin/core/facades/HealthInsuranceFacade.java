package org.korgut.clinicapi.domain.admin.core.facades;


import org.korgut.clinicapi.domain.admin.core.model.commands.CreateHealthInsuranceCommand;
import org.korgut.clinicapi.domain.admin.core.model.entities.HealthInsurance;
import org.korgut.clinicapi.domain.admin.core.model.enums.CrudOperation;
import org.korgut.clinicapi.domain.admin.core.model.exceptions.CrudException;
import org.korgut.clinicapi.domain.admin.core.model.exceptions.DatabaseException;
import org.korgut.clinicapi.domain.admin.core.model.exceptions.ValidationException;
import org.korgut.clinicapi.domain.admin.core.model.results.CommandResult;
import org.korgut.clinicapi.domain.admin.core.model.results.HeathInsuranceHasBeenCreated;
import org.korgut.clinicapi.domain.admin.core.ports.incoming.CreateHealthInsurance;
import org.korgut.clinicapi.domain.admin.core.ports.outgoing.CooperativeValidator;
import org.korgut.clinicapi.domain.admin.core.ports.outgoing.HealthInsuranceDatabase;

import java.util.UUID;

public class HealthInsuranceFacade implements CreateHealthInsurance {
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
}
