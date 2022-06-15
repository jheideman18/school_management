package za.ac.cput.school_management.factory;
/*
Jody Heideman 219307725
CityFactory.java
11/06/22
 */
import org.apache.commons.lang3.StringUtils;
import za.ac.cput.school_management.domain.City;
import za.ac.cput.school_management.domain.Country;

public class CityFactory {

    public static City createCity(String id , String name , Country country)
    {

        if(id == null || id.equals("")){

            throw new IllegalArgumentException("id is required");
        }
        if(name == null || name.equals("") ){
            name = StringUtils.EMPTY;
           throw new IllegalArgumentException("name has to be entered");


        }
        if(country == null || country.equals("") ){

            throw new IllegalArgumentException("country");
        }

        return new City.Builder()
                .setId(id)
                .setName(name)
                .setCountry(country)
                .build();
    }

}
