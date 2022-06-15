package za.ac.cput.school_management.service;

import za.ac.cput.school_management.domain.address.Country;

import java.util.List;

public interface ICountryService extends IService<Country, String>{

    List<Country> findAll();
}
