package za.ac.cput.ServiceTest;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.school_management.domain.address.City;
import za.ac.cput.school_management.domain.address.Country;
import za.ac.cput.school_management.domain.employee.EmployeeAddress;
import za.ac.cput.school_management.factory.address.CityFactory;
import za.ac.cput.school_management.factory.address.CountryFactory;
import za.ac.cput.school_management.factory.employee.EmployeeAddressFactory;
import za.ac.cput.school_management.repository.employee.EmployeeAddressRepository;
import za.ac.cput.school_management.repository.employee.IEmployeeAddressRepository;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class EmployeeAddressServiceTest {
    private EmployeeAddress employeeAddress;
    private IEmployeeAddressRepository repository;
    private Country country;
    private City city;

    @BeforeEach void setUp(){
        country = CountryFactory.createCountry("1555", "South Africa");
        city = CityFactory.createCity("898", "Cape Town", country);

        this.employeeAddress = EmployeeAddressFactory.createEmployeeAddress("2192555",  "34",
                "Applebury", "105A", "Apple", 7878, city);
        this.repository = EmployeeAddressRepository.getRepository();
        EmployeeAddress saved = this.repository.save(this.employeeAddress);
        assertSame(this.employeeAddress, saved);
    }

    @AfterEach void tearDown(){
        this.repository.delete(this.employeeAddress);
    }

    @Test
    void save(){
        EmployeeAddress saved = this.repository.save(this.employeeAddress);
        System.out.println(saved);
        assertNotNull(saved);
        assertSame(this.employeeAddress, saved);
    }

    @Test
    void read(){
        Optional<EmployeeAddress> read = this.repository.read(this.employeeAddress.getStaffId());
        assertTrue(read.isPresent());
        assertSame(this.employeeAddress, read.get());
    }

    @Test
    void delete(){
        EmployeeAddress saved = this.repository.save(this.employeeAddress);
        List<EmployeeAddress> employeeAddressList = this.repository.getAll();
        assertEquals(1, employeeAddressList.size());
        this.repository.delete(saved);
        employeeAddressList = this.repository.getAll();
        assertEquals(1, employeeAddressList.size());

    }

    @Test
    void getAll(){
        this.repository.save(this.employeeAddress);
        List<EmployeeAddress> employeeAddressList = this.repository.getAll();
        assertEquals(1, employeeAddressList.size());
    }
}
