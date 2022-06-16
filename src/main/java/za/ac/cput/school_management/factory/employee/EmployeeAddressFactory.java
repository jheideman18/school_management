package za.ac.cput.school_management.factory.employee;
/* EmployeeAddressFactory.Java
 *  Entity for EmployeeAddressFactory
 *  Author: Yasmeen Nel (219250553)
 *  Date: 13 June 2022
 * */

import za.ac.cput.school_management.domain.address.Address;
import za.ac.cput.school_management.domain.address.City;
import za.ac.cput.school_management.domain.address.Country;
import za.ac.cput.school_management.domain.employee.EmployeeAddress;
import za.ac.cput.school_management.factory.address.AddressFactory;
import za.ac.cput.school_management.factory.address.CityFactory;
import za.ac.cput.school_management.factory.address.CountryFactory;

public class EmployeeAddressFactory {
    public static EmployeeAddress createEmployeeAddress(String staffId, String unitNumber, String complexName,
                                                        String streetNumber, String streetName, int postalCode,
                                                        City city){

        Address address = AddressFactory.createAddress(unitNumber, complexName, streetNumber,
                                                        streetName, postalCode, city);


        return new EmployeeAddress.EmployeeAddressBuilder()
                .createStaffId(staffId)
                .createAddress(address)
                .build();

    }
}
