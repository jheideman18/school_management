package za.ac.cput.ControllerTest;
/*
Jody Heideman 219307725
CountryControllerTest.java
*/
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.cput.controller.CountryController;
import za.ac.cput.domain.address.Country;
import za.ac.cput.factory.address.CountryFactory;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CountryControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private CountryController controller;
    @Autowired private TestRestTemplate restTemplate;
    private Country country ;

    private  String baseUrl ;


    @BeforeEach
    void setUp(){
        country = CountryFactory
                .createCountry("01" , "South Africa");
        country = CountryFactory
                .createCountry("02" , "America");

        baseUrl = "http://localhost:" + this.port + "/school/country/";
    }

    @Order(1)
    @Test
    void save() {
        String url = baseUrl + "save/";
        System.out.println(url);
        ResponseEntity<Country> response = this.restTemplate
                .postForEntity(url, this.country,Country.class);
        System.out.println(response);
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                ()-> assertNotNull(response.getBody())

        );
    }

    @Order(2)
    @Test
    void read() {
        String url = baseUrl + "read/" + this.country.getId();
        System.out.println(url);
        ResponseEntity<Country> response = this.restTemplate.getForEntity(url, Country.class);
        System.out.println(response);
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                ()-> assertNotNull(response.getBody())

        );
    }
    @Order(3)
    @Test
    void delete() {
        String url = baseUrl + "delete/" + this.country.getId();
        this.restTemplate.delete(url);
    }
    @Order(4)
    @Test
    void findAll() {
        String url = baseUrl + "findAll/";
        System.out.println(url);
        ResponseEntity<Country[]> response = this.restTemplate.getForEntity(url, Country[].class);
        System.out.println(Arrays.asList(response.getBody()));

        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                ()-> assertTrue(response.getBody().length==0)
        );

    }
}