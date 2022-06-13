package za.ac.cput.school_management.test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.school_management.domain.StudentAddress;
import za.ac.cput.school_management.factory.StudentAddressFactory;
import za.ac.cput.school_management.repository.StudentAddressRepository;
import za.ac.cput.school_management.repository.StudentAddressRepositoryImp;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class StudentAddressRepositoryImpTest {
    private StudentAddress studentAddress;
    private StudentAddressRepository repository;

    @BeforeEach
    void setUp(){
        this.studentAddress = StudentAddressFactory.build( "test-id", "test-address");
        this.repository = StudentAddressRepositoryImp.studentAddressRepository();
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