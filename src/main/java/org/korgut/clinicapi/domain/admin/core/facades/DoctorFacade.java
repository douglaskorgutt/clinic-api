package org.korgut.clinicapi.domain.admin.core.facades;


import org.korgut.clinicapi.domain.admin.core.model.commands.CreateDoctorCommand;
import org.korgut.clinicapi.domain.admin.core.model.commands.FindDoctorCommand;
import org.korgut.clinicapi.domain.admin.core.model.entities.Doctor;
import org.korgut.clinicapi.domain.admin.core.model.entities.HealthInsurance;
import org.korgut.clinicapi.domain.admin.core.model.enums.CrudOperation;
import org.korgut.clinicapi.domain.admin.core.model.exceptions.CrudException;
import org.korgut.clinicapi.domain.admin.core.model.exceptions.DatabaseException;
import org.korgut.clinicapi.domain.admin.core.model.results.CommandResult;
import org.korgut.clinicapi.domain.admin.core.model.results.DoctorHasBeenCreated;
import org.korgut.clinicapi.domain.admin.core.model.results.DoctorHasBeenFound;
import org.korgut.clinicapi.domain.admin.core.ports.incoming.CreateDoctor;
import org.korgut.clinicapi.domain.admin.core.ports.incoming.FindDoctor;
import org.korgut.clinicapi.domain.admin.core.ports.outgoing.DoctorDatabase;
import org.korgut.clinicapi.domain.admin.core.ports.outgoing.HealthInsuranceDatabase;

import java.util.Optional;
import java.util.UUID;


public class DoctorFacade implements CreateDoctor, FindDoctor {

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
            if (Boolean.FALSE.equals(healthInsurance.get().getIsValid()))
                throw new CrudException(Doctor.class, CrudOperation.CREATE, "Health insurance is no longer valid");

            Doctor doctor = new Doctor(
                    UUID.randomUUID().toString(),
                    createDoctorCommand.firstName(),
                    createDoctorCommand.lastName(),
                    createDoctorCommand.specialty(),
                    healthInsurance.get()
            );

            Doctor created = doctorDatabase.createDoctor(doctor);

            String resultCommandId = UUID.randomUUID().toString();
            return new DoctorHasBeenCreated(created.id(), created.name(), resultCommandId, createDoctorCommand.commandId());
        } catch (DatabaseException e) {
            throw new CrudException(Doctor.class, CrudOperation.CREATE, e.getMessage());
        }
    }

    @Override
    public CommandResult findDoctorByName(FindDoctorCommand findDoctorCommand) throws CrudException {
        try {
            Optional<Doctor> doctor = this.doctorDatabase.findDoctorByName(findDoctorCommand.name());

            if (Boolean.TRUE.equals(doctor.isEmpty()))
                throw new CrudException(
                        Doctor.class,
                        CrudOperation.CREATE,
                        "Doctor with name [" + findDoctorCommand.name() + "] was not found"
                );

            return new DoctorHasBeenFound(UUID.randomUUID().toString(), findDoctorCommand.id(), doctor.get());
        } catch (DatabaseException e) {
            throw new CrudException(Doctor.class, CrudOperation.CREATE, e.getMessage());
        }
    }
}
