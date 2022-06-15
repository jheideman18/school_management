package za.ac.cput.school_management.service;

import za.ac.cput.school_management.domain.address.City;
import za.ac.cput.school_management.repository.address.CityRepository;

import java.util.List;
import java.util.Optional;

public class CityService implements ICityService{

    private final CityRepository repository;
    private static CityService SERVICE ;

    private CityService(){
        this.repository = CityRepository.cityRepository();
    }

    public static CityService getService(){
        if(SERVICE == null)
            SERVICE = new CityService();
        return SERVICE;
    }
    @Override
    public City save(City city) {
        return this.repository.save(city);
    }

    @Override
    public Optional<City> read(String s) {
        return this.repository.read(s);
    }

    @Override
    public void delete(City city) {
        this.repository.delete(city);
    }
    @Override
    public List<City> findByCountryId(String countryId) {
        return this.repository.findByCountryId(countryId);
    }
}
