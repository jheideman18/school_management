package za.ac.cput.FactoryTest;
/*
Jody Heideman 219307725
CountryTest.java
11/06/22
 */
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.address.City;
import za.ac.cput.domain.address.Country;
import za.ac.cput.factory.address.CityFactory;
import za.ac.cput.factory.address.CountryFactory;

import static org.junit.jupiter.api.Assertions.*;

class CountryFactoryTest {


    @Test
    public void buildWithSuccess(){

        Country country = CountryFactory.createCountry("15" , "South Africa");
        System.out.println(country);
        assertAll(
                ()-> assertNotNull(country),
                ()-> assertNotNull(country.getName())
        );

    }

    @Test
    public void buildWithError(){

        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                CountryFactory
                        .createCountry(null , "Cape Town"));

        String exceptionMessage = exception.getMessage();
        System.out.println(exceptionMessage);
        assertSame("id is required" , exceptionMessage);

    }
}