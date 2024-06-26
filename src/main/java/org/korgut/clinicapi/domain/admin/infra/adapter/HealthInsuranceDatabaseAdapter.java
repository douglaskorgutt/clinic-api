package org.korgut.clinicapi.domain.admin.infra.adapter;

import org.korgut.clinicapi.domain.admin.core.model.entities.HealthInsurance;
import org.korgut.clinicapi.domain.admin.core.model.exceptions.DatabaseException;
import org.korgut.clinicapi.domain.admin.core.ports.outgoing.HealthInsuranceDatabase;
import org.korgut.clinicapi.domain.admin.infra.repository.HealthInsuranceRepository;

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

    @Override
    public Optional<HealthInsurance> findHealthInsuranceByName(String name) throws DatabaseException {
        return Optional.empty();
    }

    @Override
    public HealthInsurance updateHealthInsurance(HealthInsurance healthInsurance) throws DatabaseException {
        return null;
    }

    @Override
    public HealthInsurance deleteHealthInsuranceById(String healthInsuranceId) throws DatabaseException {
        return null;
    }
}
