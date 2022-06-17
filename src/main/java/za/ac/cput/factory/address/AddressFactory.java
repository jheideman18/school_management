package za.ac.cput.factory.address;

import za.ac.cput.domain.address.Address;
import za.ac.cput.domain.address.City;

/*
Jody Heideman 219307725
AddressFactory.java
11/06/22
 */
public class AddressFactory {
    public static Address
    createAddress(String unitNumber, String complexName, String streetNumber,String streetName, int postalCode, City city)

    {

    if( streetNumber == null||streetNumber.equals("")){
        throw new IllegalArgumentException("street number");
    }
        if( streetName == null ||streetName.equals("")){
            throw new IllegalArgumentException("street name");
        }
        if(postalCode < 1000){
            throw new IllegalArgumentException("number must be between 1000-9999");
        }else if(postalCode > 9000){
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
