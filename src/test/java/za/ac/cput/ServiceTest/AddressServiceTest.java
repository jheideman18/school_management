package za.ac.cput.ServiceTest;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.school_management.domain.address.Address;
import za.ac.cput.school_management.domain.address.City;
import za.ac.cput.school_management.domain.address.Country;
import za.ac.cput.school_management.factory.address.AddressFactory;
import za.ac.cput.school_management.factory.address.CityFactory;
import za.ac.cput.school_management.factory.address.CountryFactory;
import za.ac.cput.school_management.repository.address.CountryRepository;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class AddressServiceTest {

    private City city;
    private Country country;
    private Address address;
    private CountryRepository repository;

    @BeforeEach
    void setUp(){
        country = CountryFactory.createCountry("01","South Africa");
        city = CityFactory.createCity("01", "Cape Town",country);
        address = AddressFactory.createAddress("01",
                "Brand",
                "15",
                "Cresent",
                1940,
                city);



        this.repository = CountryRepository.countryRepository();
    }

    @AfterEach
    void tearDown(){
        this.repository.delete(this.country);

    }
    @Test
    public void save() {
        Country saved = this.repository.save(this.country);
        assertNotNull(saved);
        assertSame(this.country, saved);

    }

    @Test
    public void delete() {
        Country saved = this.repository.save(this.country);
        List<Country> countryList = this.repository.findAll();
        assertEquals(1, countryList.size());
        this.repository.delete(this.country);
        countryList = this.repository.findAll();
        assertEquals(0, countryList.size());
    }

    @Test
    public void read() {
        Country saved = this.repository.save(this.country);
        Optional<Country> read = this.repository.read(saved.getId());
        assertAll(

                () -> assertTrue(read.isPresent()),
                () -> assertSame(saved, read.get())
        );
    }

    @Test
    public void findAll(){
        this.repository.save(this.country);
        List<Country> countryList = this.repository.findAll();
        assertEquals(1, countryList.size());
    }


}