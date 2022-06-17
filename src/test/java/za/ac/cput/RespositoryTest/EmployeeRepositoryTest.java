/* EmployeeRepository.java
   Author: Damone Hartnick
   Student Number : 219093717
   Date: June 2022
*/
package za.ac.cput.RespositoryTest;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.employee.Employee;
import za.ac.cput.factory.employee.EmployeeFactory;
import za.ac.cput.repository.employee.EmployeeRepository;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class EmployeeRepositoryTest {

    private Employee employee;
    private EmployeeRepository repository;

    @BeforeEach
    void setUp() {
        this.employee = EmployeeFactory.createEmployee(
                "159756875",
                "hartnickdamone@gmail.com",
                "Damone",
                "Shelly",
                "Dale");

        this.repository = EmployeeRepository.getRepository();


    }

    @AfterEach
    void tearDown() {
        this.repository.delete(this.employee);

    }




    @Test
    void save() {
        Employee saved = this.repository.save(this.employee);
        assertNotNull(saved);
        assertSame(this.employee, saved);
    }

    @Test
    void read() {
        Employee saved = this.repository.save(this.employee);
        Optional<Employee> read = this.repository.read(saved.getStaffId());
        assertAll(
        () -> assertTrue(read.isPresent()),
                () ->assertSame(saved,read.get())

        );
    }


    @Test
    void delete() {
        Employee saved = this.repository.save(this.employee);
        List<Employee> employeeList= this.repository.findAll();
        assertEquals(1, employeeList.size());
        this.repository.delete(this.employee);
        employeeList= this.repository.findAll();
        assertEquals(0,employeeList.size());
    }

    @Test
    void findAll() {
        this.repository.save(this.employee);
        List<Employee> employeeList= this.repository.findAll();
        assertEquals(1,employeeList.size());
    }

    @Test
    void findByStaffId(){
        this.repository.save(this.employee);
        List<Employee> employeeList= this.repository.findByStaffId(employee.getStaffId());
        System.out.println(employee);
        assertNotNull(employeeList);

    }

    @Test
    void findEmployeeFirstNameByEmail() {

    }

    @Test
    void existsByEmail() {

    }

    @Test
    void existsByStaffId() {

    }


}
