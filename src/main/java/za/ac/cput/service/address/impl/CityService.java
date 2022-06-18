package za.ac.cput.service.address.impl;
/*
Jody Heideman 219307725
ICityService.java
14/06/22
 */
import org.springframework.stereotype.Service;
import za.ac.cput.domain.address.City;
import za.ac.cput.repository.address.CityRepository;
import za.ac.cput.service.address.ICityService;

import java.util.List;
import java.util.Optional;

@Service
public class CityService implements ICityService {

    private CityRepository repository;
    private static ICityService SERVICE;

    public CityService(){
        this.repository = CityRepository.cityRepository();
    }
    public static ICityService getService(){
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

    public List<City> findAll(){
     return this.repository.findAll();
    }

    @Override
    public void deleteById(String id) {
        Optional<City> city = read(id);
        if(city.isPresent()){
        delete(city.get());
        }
    }
}
