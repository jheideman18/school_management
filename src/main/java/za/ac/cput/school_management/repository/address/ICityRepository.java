package za.ac.cput.school_management.repository.address;
/*
Jody Heideman 219307725
CityRepository.java
11/06/22
 */
import za.ac.cput.school_management.domain.address.City;
import za.ac.cput.school_management.repository.IRepository;

import java.util.List;

public interface ICityRepository extends IRepository<City, String> {
    List<City> findByCountryId(String countryId);
}
