package za.ac.cput.ServiceTest;
/*
Entity for StudentAddressServiceTest.java
Chulumanco Buhle Nkwindana
219390983
 */
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.address.Address;
import za.ac.cput.domain.address.City;
import za.ac.cput.domain.address.Country;
import za.ac.cput.domain.student.StudentAddress;
import za.ac.cput.factory.address.AddressFactory;
import za.ac.cput.factory.address.CityFactory;
import za.ac.cput.factory.address.CountryFactory;
import za.ac.cput.factory.student.StudentAddressFactory;
import za.ac.cput.service.student.IStudentAddressService;
import za.ac.cput.service.student.impl.StudentAddressService;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class StudentAddressServiceTest {

    private StudentAddress studentAddressRepository;
    private IStudentAddressService service;

    private Country country = CountryFactory.createCountry("15" , "South Africa");
    private City city = CityFactory.createCity("15214" ,"Cape Town" , country);
    private Address address = AddressFactory.createAddress("01",
            "Brand",
            "15",
            "Cresent",
            1940,
            city);
    @BeforeEach
    void setUp() {
        {
            this.studentAddressRepository = StudentAddressFactory.build("1212", address);

            this.service = StudentAddressService.getService();
        }
    }

    @AfterEach
    void tearDown() {
        {
            this.service.delete(this.studentAddressRepository);
        }

    }


    @Test
    void save() {
        StudentAddress saved = this.service.save(this.studentAddressRepository);
        assertNotNull(saved);
        assertSame(this.studentAddressRepository, saved);
    }

    @Test
    void read() {
        StudentAddress saved = this.service.save(this.studentAddressRepository);
        Optional<StudentAddress> read = this.service.read(saved.getStudentID());
        assertAll(
                () -> assertTrue(read.isPresent()),
                () ->assertSame(saved,read.get()));
    }

    @Test
    void delete() {
        StudentAddress saved = this.service.save(this.studentAddressRepository);
        List<StudentAddress> StudentDB= this.service.findAll();
        assertEquals(1, StudentDB.size());
        this.service.delete(saved);
        StudentDB= this.service.findAll();
        assertEquals(0,StudentDB.size());
    }

    @Test
    void findAll() {
        this.service.save(this.studentAddressRepository);
        List<StudentAddress> StudentDB= this.service.findAll();
        assertEquals(1,StudentDB.size());
    }
}