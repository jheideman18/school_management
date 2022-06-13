package za.ac.cput.school_management.factory;

import za.ac.cput.school_management.domain.Address;
import za.ac.cput.school_management.domain.City;

import java.util.Random;

/*
Jody Heideman 219307725
AddressFactory.java
11/06/22
 */
public class AddressFactory {
    public static Address
    createAddress(String unitNumber, String complexName, String streetNumber,String streetName, int postalCode, City city)

    {
        Random code = new Random();
        int low = 1000;
        int high = 9999;
        int postalCodeGen = code.nextInt(low - high) + low;

    if( streetNumber == null||streetNumber.equals("")){
        throw new IllegalArgumentException("street number");
    }
        if( streetName == null ||streetName.equals("")){
            throw new IllegalArgumentException("street name");
        }
        if(postalCode != postalCodeGen){
            throw new IllegalArgumentException("number must be between 1000-9999");
        }
        if(city == null || city.equals("")){
            throw new IllegalArgumentException("city");
        }

    return new Address.Builder()
            .setUnitNumber(unitNumber)
            .setComplexName(complexName)
            .setStreetNumber(streetNumber)
            .setStreetName(streetName)
            .setPostalCode(postalCode)
            .setCity(city)
            .build();
    }


}
