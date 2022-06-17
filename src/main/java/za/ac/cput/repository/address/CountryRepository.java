package za.ac.cput.repository.address;

/*
Jody Heideman 219307725
CityRepository.java
11/06/22
 */


import org.springframework.stereotype.Repository;
import za.ac.cput.domain.address.Country;
import za.ac.cput.service.CityService;
import za.ac.cput.service.CountryService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class CountryRepository {

    private  List<Country> countryList;
    private static CountryRepository COUNTRY_REPOSITORY;

    private CountryRepository(){
        this.countryList = new ArrayList<>();
    }

    public static CountryRepository countryRepository(){
        if(COUNTRY_REPOSITORY == null)
            COUNTRY_REPOSITORY = new CountryRepository();
        return COUNTRY_REPOSITORY;
    }

    public Country save(Country country){
        Optional<Country> read = read(country.getId());
        if(read.isPresent()){
            delete(read.get());
        }
        this.countryList.add(country);
        return country;
    }

    public Optional<Country> read(String id)
    {
        return this.countryList.stream().filter(c -> c.getId().equalsIgnoreCase(id)).findFirst();

    }

    public void delete(Country country){

        this.countryList.remove(country);
    }

    public List<Country> findAll(){
        return this.countryList;
    }

}

