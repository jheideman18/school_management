package za.ac.cput.ControllerTest;
/*
Tim Davids 219296219
Yasmeen Nel 219250553
StudentControllerTest.java

 */
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.cput.controller.CityController;
import za.ac.cput.controller.StudentController;
import za.ac.cput.domain.address.City;
import za.ac.cput.domain.address.Country;
import za.ac.cput.domain.name.Name;
import za.ac.cput.domain.student.Student;
import za.ac.cput.factory.address.CityFactory;
import za.ac.cput.factory.address.CountryFactory;
import za.ac.cput.factory.name.NameFactory;
import za.ac.cput.factory.student.StudentFactory;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class StudentControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private StudentController controller;
    @Autowired private TestRestTemplate restTemplate;
    private Student student;

    private  String baseUrl ;
    @BeforeEach
    void setUp(){
        Name name = NameFactory.build("Damone","Dale","Hen");
           this.student = StudentFactory.build("219296219","219296219@mycput.ac.za",name);
        baseUrl = "http://localhost:" + this.port + "/school/student/";
    }

    @Order(1)
    @Test
    void save() {
        String url = baseUrl + "save/";
        System.out.println(url);
        ResponseEntity<Student> response = this.restTemplate
                .postForEntity(url, this.student,Student.class);
        System.out.println(response);
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                ()-> assertNotNull(response.getBody())

        );
    }

    @Order(2)
    @Test
    void read() {
        String url = baseUrl + "read/" + this.student.getStudentID();
        System.out.println(url);
        ResponseEntity<Student> response = this.restTemplate.getForEntity(url, Student.class);
        System.out.println(response);
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                ()-> assertNotNull(response.getBody())

        );
    }
    @Order(4)
    @Test
    void delete() {
        String url = baseUrl + "delete/" + this.student.getStudentID();

        this.restTemplate.delete(url);
    }
    @Order(3)
    @Test
    void findAll() {
        String url = baseUrl + "findAll/";
        System.out.println(url);
        ResponseEntity<Student[]> response = this.restTemplate.getForEntity(url, Student[].class);
        System.out.println(Arrays.asList(response.getBody()));

        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                ()-> assertTrue(response.getBody().length==0)
        );

    }
}