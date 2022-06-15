/* EmployeeFactoryTest.java
   Author: Damone Hartnick
   Student Number : 219093717
   Date: June 2022
*/
package za.ac.cput.FactoryTest;

import org.junit.jupiter.api.Test;
import za.ac.cput.school_management.domain.employee.Employee;
import za.ac.cput.school_management.factory.employee.EmployeeFactory;

import static org.junit.jupiter.api.Assertions.*;

public class EmployeeFactoryTest {

    //String staffId,String email,String middleName, String firstName, String lastName

    @Test
    void buildWithSuccess() {
        Employee employee = EmployeeFactory.createEmployee(
                "025896314",
                "jsteyn18@gmail.com",
                "April",
                "John",
                "Steyn");
        System.out.println(employee.toString());
        assertNotNull(employee);
    }


    @Test
     void buildWithError(){
        Exception exception = assertThrows(IllegalArgumentException.class,()
                ->EmployeeFactory.createEmployee(
                        null,"jsteyn18@gmail.com","April"
                ,"John","Steyn"));
        String exceptionMessage = exception.getMessage();
        System.out.println(exceptionMessage);
        assertSame("staffid required" , exceptionMessage);



    }

}
