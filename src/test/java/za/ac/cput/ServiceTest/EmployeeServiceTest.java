/* EmployeeServiceImpTest.java
   Author: Damone Hartnick
   Student Number : 219093717
   Date: June 2022
*/
package za.ac.cput.ServiceTest;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import za.ac.cput.domain.employee.Employee;
import za.ac.cput.domain.name.Name;
import za.ac.cput.factory.employee.EmployeeFactory;
import za.ac.cput.factory.name.NameFactory;
import za.ac.cput.service.employee.impl.EmployeeService;
import za.ac.cput.service.employee.IEmployeeService;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class EmployeeServiceTest {

    @Mock
    private Employee employeeRepository;

    @InjectMocks
    private IEmployeeService service;

    @BeforeEach
    void setUp() {
        Name name = NameFactory.build("Damone","Dale","Hen");

        this.employeeRepository = EmployeeFactory.createEmployee(
                "159756875",
                "hartnickdamone@gmail.com",
                name);

        this.service = EmployeeService.getService();
    }

    @AfterEach
    void tearDown() {
        this.service.delete(this.employeeRepository);
    }

    @Test
    void save() {
        Employee saved = this.service.save(this.employeeRepository);
        assertNotNull(saved);
        assertSame(this.employeeRepository, saved);

    }

    @Test
    void read() {
        Employee saved = this.service.save(this.employeeRepository);
        Optional<Employee> read = this.service.read(saved.getStaffId());
        assertAll(
                () -> assertTrue(read.isPresent()),
                () ->assertSame(saved,read.get())

        );
    }

    @Test
    void delete() {
        Employee saved = this.service.save(this.employeeRepository);
        List<Employee> employeeList= this.service.findAll();
        assertEquals(1, employeeList.size());
        this.service.delete(saved);
        employeeList= this.service.findAll();
        assertEquals(0,employeeList.size());
    }

    @Test
    void findAll() {
        this.service.save(this.employeeRepository);
        List<Employee> employeeList= this.service.findAll();
        assertEquals(1,employeeList.size());
    }

    @Test
    void findByStaffId() {
        this.service.findByStaffId("2556678");
        List<Employee> employeeList= this.service.findByStaffId(employeeRepository.getStaffId());
        System.out.println(employeeRepository);
        assertNotNull(employeeList);
    }

    @Test
    void findEmployeeFirstNameByEmail() {
        this.service.findEmployeeFirstNameByEmail("hg@gmail.com");
        Optional<Employee> employeeOptional= this.service.findEmployeeFirstNameByEmail(employeeRepository.getEmail());
        System.out.println(employeeOptional);
        assertNotNull(employeeOptional);


    }

    @Test
    boolean existsByEmail() {

        return false;
    }

    @Test
    boolean existsByStaffId() {

        return false;
    }

}
