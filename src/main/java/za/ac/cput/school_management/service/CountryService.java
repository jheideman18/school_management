package za.ac.cput.school_management.service;

import za.ac.cput.school_management.domain.address.Country;
import za.ac.cput.school_management.repository.address.CountryRepository;

import java.util.List;
import java.util.Optional;

public class CountryService implements ICountryService{

    private final CountryRepository repository;
    private static CountryService SERVICE;

    private CountryService(){
        this.repository = CountryRepository.countryRepository();
    }

    public static CountryService getService() {
        if (SERVICE == null)
            SERVICE = new CountryService();
        return SERVICE;

    }
        @Override
    public Country save(Country country) {
        return this.repository.save(country);
    }

    @Override
    public Optional<Country> read(String s) {
        return this.repository.read(s);
    }

    @Override
    public void delete(Country country) {
        this.repository.delete(country);
    }

    @Override
    public List<Country> findAll() {
        return this.repository.findAll();
    }
}
