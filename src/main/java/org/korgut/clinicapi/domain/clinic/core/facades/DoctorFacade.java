package org.korgut.clinicapi.domain.clinic.core.facades;

import org.korgut.clinicapi.domain.clinic.core.model.commands.CreateDoctorCommand;
import org.korgut.clinicapi.domain.clinic.core.model.entities.Doctor;
import org.korgut.clinicapi.domain.clinic.core.model.entities.HealthInsurance;
import org.korgut.clinicapi.domain.clinic.core.model.enums.CrudOperation;
import org.korgut.clinicapi.domain.clinic.core.model.exceptions.CrudException;
import org.korgut.clinicapi.domain.clinic.core.model.exceptions.DatabaseException;
import org.korgut.clinicapi.domain.clinic.core.model.results.DoctorHasBeenCreated;
import org.korgut.clinicapi.domain.clinic.core.model.results.CommandResult;
import org.korgut.clinicapi.domain.clinic.core.ports.incoming.CreateDoctor;
import org.korgut.clinicapi.domain.clinic.core.ports.outgoing.DoctorDatabase;
import org.korgut.clinicapi.domain.clinic.core.ports.outgoing.HealthInsuranceDatabase;

import java.util.Optional;
import java.util.UUID;


public class DoctorFacade implements CreateDoctor {

    private final HealthInsuranceDatabase healthInsuranceDatabase;
    private final DoctorDatabase doctorDatabase;

    public DoctorFacade(
            final HealthInsuranceDatabase healthInsuranceDatabase,
            final DoctorDatabase doctorDatabase
    ) {
        this.healthInsuranceDatabase = healthInsuranceDatabase;
        this.doctorDatabase = doctorDatabase;
    }

    @Override
    public CommandResult createDoctor(CreateDoctorCommand createDoctorCommand) throws CrudException {
        try {
            // Find health insurance
            Optional<HealthInsurance> healthInsurance = this.healthInsuranceDatabase.findHealthInsuranceById(createDoctorCommand.healthInsuranceId());

            // If unable to find health insurance, throw
            if (healthInsurance.isEmpty())
                throw new CrudException(
                        Doctor.class,
                        CrudOperation.CREATE,
                        "Health insurance with id [" + createDoctorCommand.healthInsuranceId() + "] not found"
                );

            // If health insurance no longer valid, throw
            if (!healthInsurance.get().isValid())
                throw new CrudException(Doctor.class, CrudOperation.CREATE, "Health insurance is no longer valid");

            Doctor doctor = new Doctor(
                    UUID.randomUUID().toString(),
                    createDoctorCommand.firstName(),
                    createDoctorCommand.lastName(),
                    createDoctorCommand.specialty(),
                    healthInsurance.get()
            );

            Doctor created = doctorDatabase.createDoctor(doctor);

            return new DoctorHasBeenCreated(created.id(), created.name());
        } catch (DatabaseException e) {
            throw new CrudException(Doctor.class, CrudOperation.CREATE, e.getMessage());
        }
    }
}
