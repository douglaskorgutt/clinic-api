package org.korgut.clinicapi.domain.admin.core.facades;


import org.korgut.clinicapi.domain.admin.core.model.commands.patient.CreatePatientCommand;
import org.korgut.clinicapi.domain.admin.core.model.entities.City;
import org.korgut.clinicapi.domain.admin.core.model.entities.HealthInsurance;
import org.korgut.clinicapi.domain.admin.core.model.entities.Patient;
import org.korgut.clinicapi.domain.admin.core.model.enums.CrudOperation;
import org.korgut.clinicapi.domain.admin.core.model.exceptions.CrudException;
import org.korgut.clinicapi.domain.admin.core.model.exceptions.DatabaseException;
import org.korgut.clinicapi.domain.admin.core.model.results.CommandResult;
import org.korgut.clinicapi.domain.admin.core.model.results.PatientHasBeenCreated;
import org.korgut.clinicapi.domain.admin.core.ports.incoming.patient.CreatePatient;
import org.korgut.clinicapi.domain.admin.core.ports.outgoing.CityDatabase;
import org.korgut.clinicapi.domain.admin.core.ports.outgoing.HealthInsuranceDatabase;
import org.korgut.clinicapi.domain.admin.core.ports.outgoing.PatientDatabase;

import java.util.Optional;
import java.util.UUID;

public class PatientFacade implements CreatePatient {
    private final HealthInsuranceDatabase healthInsuranceDatabase;
    private final PatientDatabase patientDatabase;
    private final CityDatabase cityDatabase;

    public PatientFacade(
            HealthInsuranceDatabase healthInsuranceDatabase,
            PatientDatabase patientDatabase,
            CityDatabase cityDatabase
    ) {
        this.healthInsuranceDatabase = healthInsuranceDatabase;
        this.patientDatabase = patientDatabase;
        this.cityDatabase = cityDatabase;
    }

    @Override
    public CommandResult execute(CreatePatientCommand createPatientCommand) throws CrudException {
        try {
            // Find health insurance
            Optional<HealthInsurance> healthInsurance = healthInsuranceDatabase.findHealthInsuranceById(createPatientCommand.healthInsuranceId());

            // If unable to find health insurance, throw
            if (healthInsurance.isEmpty())
                throw new CrudException(Patient.class, CrudOperation.CREATE, "Unable to create patient because health insurance was not found");

            // If health insurance no longer valid, throw
            if (Boolean.TRUE.equals(healthInsurance.get().getIsValid()))
                throw new CrudException(Patient.class, CrudOperation.CREATE, "Health insurance is no longer valid");

            // Find city
            Optional<City> city = cityDatabase.findCityById(createPatientCommand.cityId());

            // If city not found, throws
            if (city.isEmpty())
                throw new CrudException(Patient.class, CrudOperation.CREATE, "City not found");

            // Create new patient record
            Patient patient = new Patient(
                    UUID.randomUUID().toString(),
                    createPatientCommand.name(),
                    createPatientCommand.height(),
                    createPatientCommand.weight(),
                    createPatientCommand.bloodPressure(),
                    healthInsurance.get(),
                    city.get()
            );

            // Save patient
            Patient created = patientDatabase.createPatient(patient);

            return new PatientHasBeenCreated(UUID.randomUUID().toString(), createPatientCommand.commandId(), created.getName());
        } catch (DatabaseException e) {
            throw new CrudException(Patient.class, CrudOperation.CREATE, e.getMessage());
        }
    }
}
