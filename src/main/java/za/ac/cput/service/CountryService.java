package za.ac.cput.service;

import org.springframework.stereotype.Service;
import za.ac.cput.domain.address.Country;
import za.ac.cput.factory.address.CountryFactory;
import za.ac.cput.repository.address.CountryRepository;
import za.ac.cput.repository.address.ICountryRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CountryService implements ICountryService{

    private final CountryRepository repository;
    private static CountryService SERVICE;


    private CountryService(){
        this.repository = CountryRepository.countryRepository();
    }
    public static CountryService getService(){
        if(SERVICE == null)
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

    @Override
    public void deleteById(String id) {
        Optional<Country> country = read(id);
        if(country.isPresent()){
            delete(country.get());
        }
    }
}