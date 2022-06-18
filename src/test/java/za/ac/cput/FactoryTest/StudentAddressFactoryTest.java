package za.ac.cput.FactoryTest;
/*
Entity for StudentAddressFactoryTest
Chulumanco Buhle Nkwindana
219390983
11 June 2022 */

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.address.Address;
import za.ac.cput.domain.address.City;
import za.ac.cput.domain.address.Country;
import za.ac.cput.domain.student.StudentAddress;
import za.ac.cput.factory.address.AddressFactory;
import za.ac.cput.factory.address.CityFactory;
import za.ac.cput.factory.address.CountryFactory;
import za.ac.cput.factory.student.StudentAddressFactory;

import static org.junit.jupiter.api.Assertions.*;


public class StudentAddressFactoryTest {
    private Country country = CountryFactory.createCountry("15" , "South Africa");
    private City city = CityFactory.createCity("15214" ,"Cape Town" , country);
    private Address address = AddressFactory.createAddress("01",
            "Brand",
            "15",
            "Cresent",
            1940,
            city);
    @Test
    public void buildWithSuccess(){
        StudentAddress studentAddress = StudentAddressFactory
                .build( "219390983", address );
        System.out.println(studentAddress);
        assertNotNull(studentAddress);
    }

    @Test
    public void buildWithError(){
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                StudentAddressFactory
                        .build( null, address));

        String exceptionMessage = exception.getMessage();
        System.out.println(exceptionMessage);
        assertEquals( "Invalid value for param: null", exceptionMessage);
    }
}
