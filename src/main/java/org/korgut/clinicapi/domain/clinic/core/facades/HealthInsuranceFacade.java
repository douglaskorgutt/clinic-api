package org.korgut.clinicapi.domain.clinic.core.facades;

import org.korgut.clinicapi.domain.clinic.core.model.commands.CreateHealthInsuranceCommand;
import org.korgut.clinicapi.domain.clinic.core.model.entities.HealthInsurance;
import org.korgut.clinicapi.domain.clinic.core.model.enums.CrudOperation;
import org.korgut.clinicapi.domain.clinic.core.model.exceptions.CrudException;
import org.korgut.clinicapi.domain.clinic.core.model.exceptions.DatabaseException;
import org.korgut.clinicapi.domain.clinic.core.model.exceptions.ValidationException;
import org.korgut.clinicapi.domain.clinic.core.model.identifiers.HealthInsuranceIdentifier;
import org.korgut.clinicapi.domain.clinic.core.model.identifiers.Identifier;
import org.korgut.clinicapi.domain.clinic.core.ports.incoming.CreateHealthInsurance;
import org.korgut.clinicapi.domain.clinic.core.ports.outgoing.CooperativeValidator;
import org.korgut.clinicapi.domain.clinic.core.ports.outgoing.HealthInsuranceDatabase;

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
    public Identifier createHealthInsurance(CreateHealthInsuranceCommand createHealthInsuranceCommand) throws CrudException {
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

            return new HealthInsuranceIdentifier(created.id(), created.name());
        } catch (DatabaseException | ValidationException e) {
            throw new CrudException(HealthInsurance.class, CrudOperation.CREATE, e.getMessage());
        }
    }
}
