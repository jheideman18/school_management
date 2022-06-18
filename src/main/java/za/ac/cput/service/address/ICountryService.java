package za.ac.cput.service.address;
/*
Jody Heideman 219307725
ICountryService.java
14/06/22
 */
import za.ac.cput.domain.address.Country;
import za.ac.cput.service.IService;

import java.util.List;

public interface ICountryService extends IService<Country, String> {

    List<Country> findAll();
     void deleteById(String id);
}
