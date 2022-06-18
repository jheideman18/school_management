package za.ac.cput.service.address;
/*
Jody Heideman 219307725
ICityService.java
14/06/22
 */
import za.ac.cput.domain.address.City;
import za.ac.cput.service.IService;

import java.util.List;

public interface ICityService extends IService<City, String> {

    List<City> findByCountryId(String countryId);
    List<City> findAll();
    void deleteById(String id);
}
