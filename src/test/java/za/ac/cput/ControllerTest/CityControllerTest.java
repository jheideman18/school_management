package za.ac.cput.ControllerTest;
/*
Jody Heideman 219307725
Chulumanco Buhle Nkwindana 219390983
CityControllerTest.java
 */
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.cput.controller.CityController;
import za.ac.cput.controller.CountryController;
import za.ac.cput.domain.address.City;
import za.ac.cput.domain.address.Country;
import za.ac.cput.factory.address.CityFactory;
import za.ac.cput.factory.address.CountryFactory;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CityControllerTest {


    @LocalServerPort
    private int port;

    @Autowired
    private CityController controller;
    @Autowired private TestRestTemplate restTemplate;
    private Country country ;
    private City city;

    private  String baseUrl ;
    @BeforeEach
    void setUp(){
        country = CountryFactory
                .createCountry("01" , "South Africa");
        city = CityFactory.createCity("01", "Cape Town", country);

        baseUrl = "http://localhost:" + this.port + "/school/city/";
    }

    @Order(1)
    @Test
    void save() {
        String url = baseUrl + "save/";
        System.out.println(url);
        ResponseEntity<City> response = this.restTemplate
                .postForEntity(url, this.city,City.class);
        System.out.println(response);
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                ()-> assertNotNull(response.getBody())

        );
    }

    @Order(2)
    @Test
    void read() {
        String url = baseUrl + "read/" + this.city.getId();
        System.out.println(url);
        ResponseEntity<City> response = this.restTemplate.getForEntity(url, City.class);
        System.out.println(response);
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                ()-> assertNotNull(response.getBody())

        );
    }
    @Order(3)
    @Test
    void delete() {
        String url = baseUrl + "delete/" + this.city.getId();

        this.restTemplate.delete(url);
    }
    @Order(4)
    @Test
    void findAll() {
        String url = baseUrl + "findAll/";
        System.out.println(url);
        ResponseEntity<City[]> response = this.restTemplate.getForEntity(url, City[].class);
        System.out.println(Arrays.asList(response.getBody()));

        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                ()-> assertTrue(response.getBody().length==0)
        );

    }
}