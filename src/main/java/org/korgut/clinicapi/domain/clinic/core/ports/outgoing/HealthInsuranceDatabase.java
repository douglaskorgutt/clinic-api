package org.korgut.clinicapi.domain.clinic.core.ports.outgoing;

import org.korgut.clinicapi.domain.clinic.core.model.entities.HealthInsurance;
import org.korgut.clinicapi.domain.clinic.core.model.exceptions.DatabaseException;

import java.util.Optional;

public interface HealthInsuranceDatabase {
    HealthInsurance createHealthInsurance(HealthInsurance healthInsurance) throws DatabaseException;

    Optional<HealthInsurance> findHealthInsuranceById(String id) throws DatabaseException;
}
