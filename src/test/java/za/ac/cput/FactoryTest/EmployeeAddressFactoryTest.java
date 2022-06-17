package za.ac.cput.FactoryTest;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.address.City;
import za.ac.cput.domain.address.Country;
import za.ac.cput.domain.employee.EmployeeAddress;
import za.ac.cput.factory.address.CityFactory;
import za.ac.cput.factory.address.CountryFactory;
import za.ac.cput.factory.employee.EmployeeAddressFactory;

import static org.junit.jupiter.api.Assertions.*;

/*  EmployeeAddressFactoryTest.Java
 *  Entity for EmployeeAddressFactoryTest
 *  Author: Yasmeen Nel (219250553)
 *  Date: 13 June 2022
 * */

public class EmployeeAddressFactoryTest {
    private Country country;
    private City city;

    @Test
    public void buildWithSuccess() {

       country = CountryFactory.createCountry("1555", "South Africa");
       city = CityFactory.createCity("898", "Cape Town", country);

        EmployeeAddress employeeAddress = EmployeeAddressFactory.createEmployeeAddress("21925553",
                "34", "Applebury", "105A", "Apple", 7878, city);
        System.out.println(employeeAddress);
        assertAll(
                () -> assertNotNull(employeeAddress),
                () -> assertNotNull(employeeAddress.getStaffId())
        );
    }

    @Test
    void buildWithError() {

       country = CountryFactory.createCountry("1555", "South Africa");
       city = CityFactory.createCity("898", "Cape Town", country);

        EmployeeAddress employeeAddress = EmployeeAddressFactory.createEmployeeAddress("",
                "34", "Applebury", "105A", "Apple", 7878, city);
        System.out.println(employeeAddress);
        assertAll(
                () -> assertNotNull(employeeAddress),
                () -> assertNotNull(employeeAddress.getStaffId())
        );
    }
}

