package za.ac.cput.ServiceTest;
/*
Jody Heideman 219307725
AddressServiceTest.java

 */
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.address.Address;
import za.ac.cput.domain.address.City;
import za.ac.cput.domain.address.Country;
import za.ac.cput.factory.address.AddressFactory;
import za.ac.cput.factory.address.CityFactory;
import za.ac.cput.factory.address.CountryFactory;
import za.ac.cput.service.address.impl.AddressService;
import za.ac.cput.service.address.IAddressService;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class AddressServiceTest {

    private City city;
    private Country country;
    private Address address;
    private IAddressService service;

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



       this.service = AddressService.getService();
    }

    @AfterEach
    void tearDown(){
        this.service.delete(this.address);

    }
    @Test
    public void save() {
        Address saved = this.service.save(this.address);
        assertNotNull(saved);
        assertSame(this.address, saved);

    }

    @Test
    public void delete() {
        Address saved = this.service.save(this.address);
        List<Address> addressList = this.service.findAll();
        assertEquals(1, addressList.size());
        this.service.delete(this.address);
        addressList = this.service.findAll();
        assertEquals(0, addressList.size());
    }

    @Test
    public void read() {
        Address saved = this.service.save(this.address);
        Optional<Address> read = (this.service.read(saved.getUnitNumber()));
        assertAll(

                () -> assertTrue(read.isPresent()),
                () -> assertSame(saved, read.get())
        );
    }

    @Test
    public void findAll(){
        this.service.save(this.address);
        List<Address> addressList = this.service.findAll();
        assertEquals(1, addressList.size());
    }


}