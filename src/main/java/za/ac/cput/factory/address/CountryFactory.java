package za.ac.cput.factory.address;
/*
Jody Heideman 219307725
CountryFactory.java
11/06/22
 */

import za.ac.cput.domain.address.Country;

public class CountryFactory {

    public static Country createCountry(String id , String name)
    {

        if( id == null || id.equals("")){

            throw new IllegalArgumentException("id is required");
        }
        if(name == null || name.equals("") ){

            throw new IllegalArgumentException("name");
        }


        return new Country.Builder()
                .setId(id)
                .setName(name)
                .build();
    }
}
