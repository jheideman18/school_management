package za.ac.cput.school_management.repository;
/*
Jody Heideman 219307725
CityRepository.java
11/06/22
 */
import za.ac.cput.school_management.domain.City;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


public class CityRepository implements ICityRepository{

    private final List<City> cityList;
    private static CityRepository CITY_REPOSITORY;

    private CityRepository(){
        this.cityList = new ArrayList<>();
    }

    public static CityRepository cityRepository(){
        if(CITY_REPOSITORY == null)
            CITY_REPOSITORY = new CityRepository();
        return CITY_REPOSITORY;
    }

    public City save(City city){
        Optional<City> read = read(city.getId());
        if(read.isPresent()){
            delete(read.get());
        }
        this.cityList.add(city);
        return city;
    }

    public Optional<City> read(String id)
    {
       return this.cityList.stream().filter(c -> c.getId().equalsIgnoreCase(id)).findFirst();

    }

    public void delete(City city){

        this.cityList.remove(city);
    }

    public List<City> findAll(){
        return this.cityList;
    }


    public List<City> findByCountryId(String countryId)
    {
        return this.cityList.stream().filter(c -> c.getId().equalsIgnoreCase(countryId))
                .collect(Collectors.toList());
    }


}
