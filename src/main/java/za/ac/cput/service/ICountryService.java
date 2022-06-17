package za.ac.cput.service;

import za.ac.cput.domain.address.Country;

import java.util.List;

public interface ICountryService extends IService<Country, String>{

    List<Country> findAll();
     void deleteById(String id);
}
