package org.korgut.clinicapi.domain.clinic.infra.adapter;

import org.korgut.clinicapi.domain.clinic.core.model.entities.HealthInsurance;
import org.korgut.clinicapi.domain.clinic.core.model.exceptions.DatabaseException;
import org.korgut.clinicapi.domain.clinic.core.ports.outgoing.HealthInsuranceDatabase;
import org.korgut.clinicapi.domain.clinic.infra.repository.HealthInsuranceRepository;

import java.util.Optional;

public class HealthInsuranceDatabaseAdapter implements HealthInsuranceDatabase {
    private final HealthInsuranceRepository healthInsuranceRepository;

    public HealthInsuranceDatabaseAdapter(HealthInsuranceRepository healthInsuranceRepository) {
        this.healthInsuranceRepository = healthInsuranceRepository;
    }

    @Override
    public HealthInsurance createHealthInsurance(HealthInsurance healthInsurance) throws DatabaseException {
        try {
            return healthInsuranceRepository.save(healthInsurance);
        } catch (Exception e) {
            throw new DatabaseException("Unable to save [" + HealthInsurance.class.getSimpleName() + "]. Error: " + e.getMessage());
        }
    }

    @Override
    public Optional<HealthInsurance> findHealthInsuranceById(String id) throws DatabaseException {
        try {
            return healthInsuranceRepository.findById(id);
        } catch (Exception e) {
            throw new DatabaseException("Unable to find [" + HealthInsurance.class.getSimpleName() + "]" +
                    " with id [" + id + "] Error: " + e.getMessage());
        }
    }
}
