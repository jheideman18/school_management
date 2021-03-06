/* EmployeeControllerTest.java
   Author: Damone Hartnick
   Student Number : 219093717
   Smangele Witness Mabaso 220047154
   Date: June 2022
*/
package za.ac.cput.ControllerTest;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.cput.controller.EmployeeController;
import za.ac.cput.domain.employee.Employee;
import za.ac.cput.domain.name.Name;
import za.ac.cput.factory.employee.EmployeeFactory;
import za.ac.cput.factory.name.NameFactory;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class EmployeeControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private EmployeeController controller;

    @Autowired private TestRestTemplate restTemplate;

    private Employee employee;

    private String baseUrl ;

    @BeforeEach
    void setUp() {
        Name name = NameFactory.build("Damone","Dale","Hen");
        this.employee = EmployeeFactory.createEmployee(
                "159756875",
                "hartnickdamone@gmail.com",
                name);

        baseUrl = "http://localhost:" + this.port + "/school/employee/";

    }
    
    @Order(1)
    @Test
    void save() {
        String url = baseUrl + "save";
        System.out.println(url);
        ResponseEntity<Employee> response = this.restTemplate
                .postForEntity(url, this.employee,Employee.class);
        System.out.println(response);
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertNotNull(response.getBody())

        );
    }

    @Order(2)
    @Test
    void read() {
        String url = baseUrl + "read/" + this.employee.getStaffId();
        System.out.println(url);
        ResponseEntity<Employee> response = this.restTemplate.getForEntity(url, Employee.class);
        System.out.println(response);
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertNotNull(response.getBody())


        );
    }

    @Order(3)
    @Test
    void delete() {
        String url = baseUrl + "delete/" + this.employee.getStaffId();
        this.restTemplate.delete(url);
    }

    @Order(4)
    @Test
    void findAll() {
        String url = baseUrl + "findAll/";
        System.out.println(url);
        ResponseEntity<Employee[]> response = this.restTemplate.getForEntity(url, Employee[].class);
        System.out.println(Arrays.asList(response.getBody()));

        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertTrue(response.getBody().length==0)


        );
    }
}