package za.ac.cput.ServiceTest;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.address.City;
import za.ac.cput.domain.address.Country;
import za.ac.cput.factory.address.CityFactory;
import za.ac.cput.factory.address.CountryFactory;
import za.ac.cput.repository.address.ICountryRepository;
import za.ac.cput.service.CountryService;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class CountryServiceTest {

    private City city;
    private Country country;
    private CountryService service;

    @BeforeEach
    void setUp(){
        Country country2 = CountryFactory.createCountry("02","America");
        country = CountryFactory.createCountry("01","South Africa");
        this.city = CityFactory.createCity("03", "New York",country2);
        this.city = CityFactory.createCity("01", "Cape Town",country);
        this.city = CityFactory.createCity("02", "Free state",country);

        this.service = CountryService.getService();
    }

    @AfterEach
    void tearDown(){
        this.service.delete(this.country);

    }
    @Test
    public void save() {
        Country saved = this.service.save(this.country);
        assertNotNull(saved);
        assertSame(this.country, saved);

    }

    @Test
    public void delete() {
        Country saved = this.service.save(this.country);
        List<Country> countryList = this.service.findAll();
        assertEquals(1, countryList.size());
        this.service.delete(this.country);
        countryList = this.service.findAll();
        assertEquals(0, countryList.size());
    }

    @Test
    public void read() {
        Country saved = this.service.save(this.country);
        Optional<Country> read = this.service.read(saved.getId());
        assertAll(

                () -> assertTrue(read.isPresent()),
                () -> assertSame(saved, read.get())
        );
    }

    @Test
    public void findAll(){
        this.service.save(this.country);
        List<Country> countryList = this.service.findAll();
        assertEquals(1, countryList.size());
    }


}