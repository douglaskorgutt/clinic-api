package org.korgut.clinicapi.domain.admin.core.facades;


import org.korgut.clinicapi.domain.admin.core.model.commands.CreateDoctorCommand;
import org.korgut.clinicapi.domain.admin.core.model.commands.DeleteDoctorCommand;
import org.korgut.clinicapi.domain.admin.core.model.commands.FindDoctorCommand;
import org.korgut.clinicapi.domain.admin.core.model.commands.UpdateDoctorCommand;
import org.korgut.clinicapi.domain.admin.core.model.entities.Doctor;
import org.korgut.clinicapi.domain.admin.core.model.entities.HealthInsurance;
import org.korgut.clinicapi.domain.admin.core.model.enums.CrudOperation;
import org.korgut.clinicapi.domain.admin.core.model.exceptions.CrudException;
import org.korgut.clinicapi.domain.admin.core.model.exceptions.DatabaseException;
import org.korgut.clinicapi.domain.admin.core.model.results.*;
import org.korgut.clinicapi.domain.admin.core.ports.incoming.CreateDoctor;
import org.korgut.clinicapi.domain.admin.core.ports.incoming.DeleteDoctor;
import org.korgut.clinicapi.domain.admin.core.ports.incoming.FindDoctor;
import org.korgut.clinicapi.domain.admin.core.ports.incoming.UpdateDoctor;
import org.korgut.clinicapi.domain.admin.core.ports.outgoing.DoctorDatabase;
import org.korgut.clinicapi.domain.admin.core.ports.outgoing.HealthInsuranceDatabase;

import java.util.Optional;
import java.util.UUID;


public class DoctorFacade implements CreateDoctor, FindDoctor, DeleteDoctor, UpdateDoctor {

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
    public CommandResult execute(CreateDoctorCommand createDoctorCommand) throws CrudException {
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
            return new DoctorHasBeenCreated(created.getId(), created.getName(), resultCommandId, createDoctorCommand.commandId());
        } catch (DatabaseException e) {
            throw new CrudException(Doctor.class, CrudOperation.CREATE, e.getMessage());
        }
    }

    @Override
    public CommandResult execute(FindDoctorCommand findDoctorCommand) throws CrudException {
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

    @Override
    public CommandResult execute(DeleteDoctorCommand deleteDoctorCommand) throws CrudException {
        try {
            String doctorName = deleteDoctorCommand.doctorName();

            // Find doctor to be deleted using doctor name
            Optional<Doctor> doctor = this.doctorDatabase.findDoctorByName(doctorName);

            // If doctor not found, throw
            if (doctor.isEmpty())
                throw new CrudException(
                        Doctor.class,
                        CrudOperation.DELETE,
                        "Doctor with name [" + doctorName + "] was not found"
                );

            // Delete doctor
            Doctor deleted = doctorDatabase.deleteDoctor(doctor.get().getId());

            return new DoctorHasBeenDeleted(
                    UUID.randomUUID().toString(),
                    deleteDoctorCommand.commandId(),
                    deleted.getId(),
                    deleted.getName()
            );
        } catch (DatabaseException e) {
            throw new CrudException(Doctor.class, CrudOperation.DELETE, e.getMessage());
        }
    }

    @Override
    public CommandResult execute(UpdateDoctorCommand command) throws CrudException {
        try {
            Doctor doctor = command.doctor();

            // If given doctor does not have health insurance information, throw
            if (doctor.getHealthInsurance() == null)
                throw new CrudException(
                        Doctor.class,
                        CrudOperation.UPDATE,
                        "Health insurance not found. Can't update doctor: "
                                + Optional.ofNullable(doctor.getName()).orElse("Doctor name not found")
                );

            // Update doctor
            Doctor updated = this.doctorDatabase.updateDoctor(command.doctor());

            return new DoctorHasBeenUpdated(UUID.randomUUID().toString(), command.commandId(), updated);
        } catch (DatabaseException e) {
            throw new CrudException(Doctor.class, CrudOperation.UPDATE, e.getMessage());
        }
    }
}
