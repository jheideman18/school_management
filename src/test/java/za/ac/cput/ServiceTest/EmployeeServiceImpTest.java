/* EmployeeServiceImpTest.java
   Author: Damone Hartnick
   Student Number : 219093717
   Date: June 2022
*/
package za.ac.cput.ServiceTest;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.school_management.domain.employee.Employee;
import za.ac.cput.school_management.factory.employee.EmployeeFactory;
import za.ac.cput.school_management.repository.employee.EmployeeRepository;
import za.ac.cput.school_management.service.EmployeeServiceImp;
import za.ac.cput.school_management.service.IEmployeeService;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class EmployeeServiceImpTest {

    private Employee employee;
    private EmployeeServiceImp service;

    @BeforeEach
    void setUp() {
        this.employee = EmployeeFactory.createEmployee(
                "2556678",
                "hg@gmail.com",
                "Nicole",
                "Jade",
                "Fisher");

        this.service = EmployeeServiceImp.getService();
    }

    @AfterEach
    void tearDown() {
        this.service.delete(this.employee);
    }

    @Test
    void save() {
        Employee saved = this.service.save(this.employee);
        assertNotNull(saved);
        assertSame(this.employee, saved);

    }

    @Test
    void read() {
        Employee saved = this.service.save(this.employee);
        Optional<Employee> read = this.service.read(saved.getStaffId());
        assertAll(
                () -> assertTrue(read.isPresent()),
                () ->assertSame(saved,read.get())

        );
    }

    @Test
    void delete() {
        Employee saved = this.service.save(this.employee);
        List<Employee> employeeList= this.service.findAll();
        assertEquals(1, employeeList.size());
        this.service.delete(saved);
        employeeList= this.service.findAll();
        assertEquals(0,employeeList.size());
    }

    @Test
    void findAll() {
        this.service.save(this.employee);
        List<Employee> employeeList= this.service.findAll();
        assertEquals(1,employeeList.size());
    }

    @Test
    void findByStaffId() {
        this.service.save(this.employee);
        List<Employee> employeeList= this.service.findByStaffId(employee.getStaffId());
        System.out.println(employee);
        assertNotNull(employeeList);
    }

}
