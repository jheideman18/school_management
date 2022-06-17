package za.ac.cput.factory.employee;
/* EmployeeAddressFactory.Java
 *  Entity for EmployeeAddressFactory
 *  Author: Yasmeen Nel (219250553)
 *  Date: 13 June 2022
 * */

import za.ac.cput.domain.address.Address;
import za.ac.cput.domain.address.City;
import za.ac.cput.domain.employee.EmployeeAddress;
import za.ac.cput.factory.address.AddressFactory;

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
