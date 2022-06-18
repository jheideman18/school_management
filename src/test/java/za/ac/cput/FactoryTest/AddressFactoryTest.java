package za.ac.cput.FactoryTest;
/*
Jody Heideman 219307725
AddressFactorTest.java
11/06/22
 */
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.address.Address;
import za.ac.cput.domain.address.City;
import za.ac.cput.domain.address.Country;
import za.ac.cput.factory.address.AddressFactory;
import za.ac.cput.factory.address.CityFactory;
import za.ac.cput.factory.address.CountryFactory;

import static org.junit.jupiter.api.Assertions.*;

class AddressFactoryTest {

    private Country country = CountryFactory.createCountry("15" , "South Africa");
    private City city = CityFactory.createCity("15214" ,"Cape Town" , country);
    @Test
    public void buildWithSuccess(){

        Address address = AddressFactory.createAddress("01",
                "Brand",
                "15",
                "Cresent",
                1940,
                city);
        System.out.println(address);
        assertAll(
                ()-> assertNotNull(address),
                ()-> assertNotNull(address.getStreetName())
        );

    }

    @Test
    public void buildWithError(){

        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                AddressFactory.createAddress("01",
                        "Brand",
                        "15",
                        "Cresent",
                        10000,
                        city));

        String exceptionMessage = exception.getMessage();
        System.out.println(exceptionMessage);
        assertSame("number must be between 1000-9999" , exceptionMessage);

    }
}