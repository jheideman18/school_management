package za.ac.cput.ServiceTest;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.school_management.domain.address.City;
import za.ac.cput.school_management.domain.address.Country;
import za.ac.cput.school_management.domain.name.Name;
import za.ac.cput.school_management.factory.address.CityFactory;
import za.ac.cput.school_management.factory.address.CountryFactory;
import za.ac.cput.school_management.factory.name.NameFactory;
import za.ac.cput.school_management.repository.address.CityRepository;
import za.ac.cput.school_management.repository.name.impl.NameRepository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class CityServiceTest {

    private City city;
    private Country country;
    private CityRepository repository;

    @BeforeEach
    void setUp(){
        Country country2 = CountryFactory.createCountry("02","America");
        country = CountryFactory.createCountry("01","South Africa");
        this.city = CityFactory.createCity("03", "New York",country2);
        this.city = CityFactory.createCity("01", "Cape Town",country);
        this.city = CityFactory.createCity("02", "Free state",country);

        this.repository = CityRepository.cityRepository();
    }

    @AfterEach
    void tearDown(){
        this.repository.delete(this.city);

    }
    @Test
    public void save() {
        City saved = this.repository.save(this.city);
        assertNotNull(saved);
        assertSame(this.city, saved);

    }

    @Test
    public void delete() {
        City saved = this.repository.save(this.city);
        List<City> cityList = this.repository.findAll();
        assertEquals(1, cityList.size());
        this.repository.delete(this.city);
        cityList = this.repository.findAll();
        assertEquals(0, cityList.size());
    }

    @Test
    public void read() {
        City saved = this.repository.save(this.city);
        Optional<City> read = this.repository.read(saved.getId());
        assertAll(

                () -> assertTrue(read.isPresent()),
                () -> assertSame(saved, read.get())
        );
    }

    @Test
    public void findAll(){
        this.repository.save(this.city);
        List<City> cityList = this.repository.findAll();
        assertEquals(1, cityList.size());
    }

    @Test
    void findByCountryId() {
        this.repository.save(this.city);
        List<City> cityList = this.repository.findByCountryId(city.getId());
        System.out.println(city);
        assertNotNull(cityList);
    }
}