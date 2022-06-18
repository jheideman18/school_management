/* EmployeeFactory.java
   Author: Damone Hartnick
   Student Number : 219093717
   Date: June 2022
*/
package za.ac.cput.factory.employee;

import za.ac.cput.domain.employee.Employee;
import za.ac.cput.domain.name.Name;
import za.ac.cput.util.Stringhelper;

public class EmployeeFactory {

    public static Employee createEmployee( String staffId, String email, Name name)
    {
        Stringhelper.checkStringParam("staffId", staffId);
        Stringhelper.checkStringParam("email", email);
        Stringhelper.checkStringParam("name", name.toString());

        return new Employee.Builder()
                .setStaffId(staffId)
                .setEmail(email)
                .setName(name)
                .build();
    }



 }
