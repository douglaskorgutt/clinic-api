package org.korgut.clinicapi.domain.clinic.infra.adapter;

import org.korgut.clinicapi.domain.clinic.core.model.entities.Doctor;
import org.korgut.clinicapi.domain.clinic.core.model.exceptions.DatabaseException;
import org.korgut.clinicapi.domain.clinic.core.ports.outgoing.DoctorDatabase;
import org.korgut.clinicapi.domain.clinic.infra.repository.DoctorRepository;

public class DoctorDatabaseAdapter implements DoctorDatabase {
    private final DoctorRepository doctorRepository;

    public DoctorDatabaseAdapter(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    @Override
    public Doctor createDoctor(Doctor doctor) throws DatabaseException {
        try {
            return this.doctorRepository.save(doctor);
        } catch (Exception e) {
            throw new DatabaseException("Unable to save [" + Doctor.class.getSimpleName() + "]. Error: " + e.getMessage());
        }
    }
}
