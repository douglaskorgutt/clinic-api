package org.korgut.clinicapi.domain.clinic.core.ports.outgoing;

import org.korgut.clinicapi.domain.clinic.core.model.entities.City;
import org.korgut.clinicapi.domain.clinic.core.model.exceptions.DatabaseException;

import java.util.Optional;

public interface CityDatabase {
    Optional<City> findCityById(String id) throws DatabaseException;
}
