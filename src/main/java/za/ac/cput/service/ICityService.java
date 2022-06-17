package za.ac.cput.service;

import za.ac.cput.domain.address.City;

import java.util.List;

public interface ICityService extends IService<City, String> {

    List<City> findByCountryId(String countryId);
    List<City> findAll();
    void deleteById(String id);
}
