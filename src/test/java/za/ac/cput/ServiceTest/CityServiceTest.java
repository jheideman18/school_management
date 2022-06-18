package za.ac.cput.ServiceTest;
/*
Jody Heideman 219307725
CityServiceTest.java

 */
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.address.City;
import za.ac.cput.domain.address.Country;
import za.ac.cput.factory.address.CityFactory;
import za.ac.cput.factory.address.CountryFactory;
import za.ac.cput.service.address.impl.CityService;
import za.ac.cput.service.address.ICityService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class CityServiceTest {

    private City city;
    private Country country;
    private ICityService service;
    private List<City> cityList = new ArrayList<>();

    @BeforeEach
    void setUp(){

        country = CountryFactory.createCountry("01","South Africa");
        city = CityFactory.createCity("03", "Cape Town",country);

       this.service = CityService.getService();
    }

    @AfterEach
    void tearDown(){
        this.service.delete(this.city);

    }
    @Test
    public void save() {
        City saved = this.service.save(this.city);
        assertNotNull(saved);
        assertSame(this.city, saved);

    }

    @Test
    public void delete() {
        City saved = this.service.save(this.city);
        cityList = this.service.findAll();
        assertEquals(1, cityList.size());
        this.service.delete(this.city);
        cityList = this.service.findAll();
        assertEquals(0, cityList.size());
    }

    @Test
    public void read() {
        City saved = this.service.save(this.city);
        Optional<City> read = this.service.read(saved.getId());
        assertAll(

                () -> assertTrue(read.isPresent()),
                () -> assertSame(saved, read.get())
        );
    }

    @Test
    public void findAll(){
        this.service.save(this.city);
        cityList = this.service.findAll();
        assertEquals(1, cityList.size());
    }

    @Test
    void findByCountryId() {
        this.service.save(this.city);
        String name;
        List<City> cityList = this.service.findByCountryId(city.getId());
        if(cityList.size() != 0){
            name = city.getName();
            assertEquals("Cape Town", name);
        }
        assertNotNull(city);

    }


}