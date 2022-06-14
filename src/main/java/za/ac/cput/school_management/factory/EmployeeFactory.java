/* EmployeeFactory.java
   Author: Damone Hartnick
   Student Number : 219093717
   Date: June 2022
*/
package za.ac.cput.school_management.factory;

import za.ac.cput.school_management.domain.Employee;

public class EmployeeFactory {

    public static Employee createEmployee( String staffid, String email, String firstName, String middleName, String lastName)
    {
        return new Employee.Builder()
                .setStaffId(staffid)
                .setEmail(email)
                .setFirstName(firstName)
                .setMiddleName(middleName)
                .setLastName(lastName)
                .build();
    }



 }
