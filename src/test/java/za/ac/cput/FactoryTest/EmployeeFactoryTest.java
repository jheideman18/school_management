/* EmployeeFactoryTest.java
   Author: Damone Hartnick
   Student Number : 219093717
   Date: June 2022
*/
package za.ac.cput.FactoryTest;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.employee.Employee;
import za.ac.cput.domain.name.Name;
import za.ac.cput.factory.employee.EmployeeFactory;
import za.ac.cput.factory.name.NameFactory;

import static org.junit.jupiter.api.Assertions.*;

public class EmployeeFactoryTest {

    Employee employee;
    Name name = NameFactory.build("Damone","Dale","Hen");
    @Test
    void buildWithSuccess() {

        this.employee = EmployeeFactory.createEmployee(
                "159756875",
                "hartnickdamone@gmail.com",
                name);
        System.out.println(employee.toString());
        assertNotNull(employee);
    }


    @Test
     void buildWithError(){
        Exception exception = assertThrows(IllegalArgumentException.class,() ->
                EmployeeFactory.createEmployee(null,"jsteyn18@gmail.com",name));
        String exceptionMessage = exception.getMessage();
        System.out.println(exceptionMessage);
        assertEquals("Invalid value for param: null" , exceptionMessage);



    }

}
