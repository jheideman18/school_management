package za.ac.cput.RespositoryTest;
/*
Entity for StudentAddressRepositoryTest
Chulumanco Buhle Nkwindana
219390983
11 June 2022 */
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
import za.ac.cput.repository.student.StudentAddressRepository;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class StudentAddressRepositoryTest {
    private StudentAddress studentAddress;
    private StudentAddressRepository repository;
    private Country country = CountryFactory.createCountry("15" , "South Africa");
    private City city = CityFactory.createCity("15214" ,"Cape Town" , country);
    private Address address = AddressFactory.createAddress("01",
            "Brand",
            "15",
            "Cresent",
            1940,
            city);
    @BeforeEach
    void setUp(){
        this.studentAddress = StudentAddressFactory.build( "test-id", address);
        this.repository = StudentAddressRepository.studentAddressRepository();
    }

    @AfterEach
    void tearDown(){
        this.repository.delete(this.studentAddress);
    }


    @Test
    void save() {
        StudentAddress saved = this.repository.save(this.studentAddress);
        assertNotNull(saved);
        assertSame(this.studentAddress,saved);
    }

    @Test
    void read() {
        StudentAddress saved = this.repository.save(this.studentAddress);
        Optional<StudentAddress> read = this.repository.read(saved.getStudentID());
        assertTrue(read.isPresent());
        assertSame(saved, read.get());
    }

    @Test
    void delete() {
        StudentAddress saved = this.repository.save(this.studentAddress);
        List<StudentAddress> studentAddressList = this.repository.findAll();
        assertEquals( 1, studentAddressList.size());
        this.repository.delete(saved);
        studentAddressList = this.repository.findAll();
        assertEquals( 0, studentAddressList.size());


    }

    @Test
    void findAll() {
        this.repository.save(this.studentAddress);
        List<StudentAddress> studentAddressList = this.repository.findAll();
        assertEquals( 1, studentAddressList.size());




    }
}