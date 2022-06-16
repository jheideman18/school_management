/* EmployeeFactory.java
   Author: Damone Hartnick
   Student Number : 219093717
   Date: June 2022
*/
package za.ac.cput.school_management.factory.employee;

import za.ac.cput.school_management.domain.employee.Employee;
import za.ac.cput.school_management.util.Stringhelper;

public class EmployeeFactory {

    public static Employee createEmployee( String staffId, String email, String firstName, String middleName, String lastName)
    {
        Stringhelper.checkStringParam("staffId", staffId);
        Stringhelper.checkStringParam("email", email);
        Stringhelper.checkStringParam("firstName", firstName);
        Stringhelper.checkStringParam("middleName", middleName);
        Stringhelper.checkStringParam("lastName", lastName);



        return new Employee.Builder()
                .setStaffId(staffId)
                .setEmail(email)
                .setFirstName(firstName)
                .setMiddleName(middleName)
                .setLastName(lastName)
                .build();
    }



 }
