package za.ac.cput.school_management.factory.employee;
/* EmployeeAddressFactory.Java
 *  Entity for EmployeeAddressFactory
 *  Author: Yasmeen Nel (219250553)
 *  Date: 13 June 2022
 * */

import za.ac.cput.school_management.domain.address.Address;
import za.ac.cput.school_management.domain.employee.EmployeeAddress;
import za.ac.cput.school_management.util.Stringhelper;

public class EmployeeAddressFactory {
    public static EmployeeAddress createEmployeeAddress(String staffId, Address address ){
        if(Stringhelper.isEmptyorNull(staffId)){
            return null;
        }


        return new EmployeeAddress.EmployeeAddressBuilder()
                .createStaffId(staffId)
                .createAddress(address)
                .build();

    }
}
