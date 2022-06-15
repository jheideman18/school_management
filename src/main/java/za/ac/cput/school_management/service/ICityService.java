package za.ac.cput.school_management.service;

import za.ac.cput.school_management.domain.address.City;
import za.ac.cput.school_management.service.IService;

import java.util.List;

public interface ICityService extends IService<City, String> {

    List<City> findByCountryId(String countryId);
}
