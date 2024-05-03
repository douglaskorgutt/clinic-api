package org.korgut.clinicapi.domain.admin.core.ports.outgoing;


import org.korgut.clinicapi.domain.admin.core.model.entities.City;
import org.korgut.clinicapi.domain.admin.core.model.exceptions.DatabaseException;

import java.util.Optional;

public interface CityDatabase {
    Optional<City> findCityById(String id) throws DatabaseException;
}
