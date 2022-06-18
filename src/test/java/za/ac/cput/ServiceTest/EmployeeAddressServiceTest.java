package za.ac.cput.ServiceTest;
/*  EmployeeAddressService.Java
 *  Entity for EmployeeAddressServiceTest
 *  Author: Yasmeen Nel (219250553)
 *
 * */
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import za.ac.cput.domain.address.City;
import za.ac.cput.domain.address.Country;
import za.ac.cput.domain.employee.EmployeeAddress;
import za.ac.cput.factory.address.CityFactory;
import za.ac.cput.factory.address.CountryFactory;
import za.ac.cput.factory.employee.EmployeeAddressFactory;
import za.ac.cput.service.employee.impl.EmployeeAddressService;
import za.ac.cput.service.employee.IEmployeeAddressService;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class EmployeeAddressServiceTest {

    @Mock
    private EmployeeAddress employeeAddressRepository;

    @InjectMocks
    private IEmployeeAddressService service;

    private Country country;
    private City city;


    @BeforeEach void setUp(){
        country = CountryFactory.createCountry("1555", "South Africa");
        city = CityFactory.createCity("898", "Cape Town", country);

        this.employeeAddressRepository = EmployeeAddressFactory.createEmployeeAddress("2192555",  "34",
                "Applebury", "105A", "Apple", 7878, city);
        this.service = EmployeeAddressService.getService();

        EmployeeAddress saved = this.service.save(this.employeeAddressRepository);
        assertSame(this.employeeAddressRepository, saved);
    }

    @AfterEach void tearDown(){
        this.service.delete(this.employeeAddressRepository);
    }

    @Test
    void save(){
        EmployeeAddress saved = this.service.save(this.employeeAddressRepository);
        System.out.println(saved);
        assertNotNull(saved);
        assertSame(this.employeeAddressRepository, saved);
    }

    @Test
    void read(){
        Optional<EmployeeAddress> read = this.service.read(this.employeeAddressRepository.getStaffId());
        assertTrue(read.isPresent());
        assertSame(this.employeeAddressRepository, read.get());
    }

    @Test
    void delete(){
        EmployeeAddress saved = this.service.save(this.employeeAddressRepository);
        List<EmployeeAddress> employeeAddressList = this.service.getAll();
        assertEquals(1, employeeAddressList.size());
        this.service.delete(saved);
        employeeAddressList = this.service.getAll();
        assertEquals(0, employeeAddressList.size());

    }

    @Test
    void getAll(){
        this.service.save(this.employeeAddressRepository);
        List<EmployeeAddress> employeeAddressList = this.service.getAll();
        assertEquals(1, employeeAddressList.size());
    }
}
