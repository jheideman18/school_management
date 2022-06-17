package za.ac.cput.repository.address;

/*
Jody Heideman 219307725
CityRepository.java
11/06/22
 */
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.address.City;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


public class CityRepository{

    private  List<City> cityList;
    private  List<City> newCityList;
    private static CityRepository CITY_REPOSITORY;


    public static CityRepository cityRepository(){
        if(CITY_REPOSITORY == null)
            CITY_REPOSITORY = new CityRepository();
        return CITY_REPOSITORY;
    }
    private CityRepository(){
        this.cityList = new ArrayList<>();
        this.newCityList = new ArrayList<>();
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

       /* for(int i =0; i < cityList.size(); i++){
          cityList.add(city);
         System.out.println(cityList.get(i));
        }*/
        return this.cityList;
    }


    public List<City> findByCountryId(String countryId)
    {
        return this.cityList.stream().filter(c -> c.getId().equalsIgnoreCase(countryId))
                .collect(Collectors.toList());
    }


}
