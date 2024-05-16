package org.korgut.clinicapi.domain.admin.core.ports.outgoing;


import org.korgut.clinicapi.domain.admin.core.model.entities.HealthInsurance;
import org.korgut.clinicapi.domain.admin.core.model.exceptions.DatabaseException;

import java.util.Optional;

public interface HealthInsuranceDatabase {
    HealthInsurance createHealthInsurance(HealthInsurance healthInsurance) throws DatabaseException;

    Optional<HealthInsurance> findHealthInsuranceById(String id) throws DatabaseException;

    Optional<HealthInsurance> findHealthInsuranceByName(String name) throws DatabaseException;

    HealthInsurance updateHealthInsurance(HealthInsurance healthInsurance) throws DatabaseException;
}
