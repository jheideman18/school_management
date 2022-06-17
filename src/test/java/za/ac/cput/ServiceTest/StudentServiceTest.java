package za.ac.cput.ServiceTest;
/* StudentServiceTest.Java
 *  Author: Tim Davids 219296219
 *  Entity for Student
 *  June Assignment
 *  Date: 09 June 2022
 * */

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.employee.Employee;
import za.ac.cput.domain.student.Student;
import za.ac.cput.factory.student.StudentFactory;
import za.ac.cput.service.StudentService;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class StudentServiceTest {
    private Student StudentRepository;
    private StudentService SERVICE;


    @BeforeEach
    void setUp() {
        {
            this.StudentRepository = StudentFactory.build("219296219","219296219@mycput.ac.za","Tim");

            this.SERVICE = (StudentService) StudentService.getService();
        }
    }

    @AfterEach
    void tearDown() {
        {
            this.SERVICE.delete(this.StudentRepository);
        }

    }

    @Test
    void getService() {
        this.SERVICE.save(this.StudentRepository);
        List<Student> StudentDB= this.SERVICE.findAll();
        assertEquals(1,StudentDB.size());
    }

    @Test
    void save() {
        Student saved = this.SERVICE.save(this.StudentRepository);
        assertNotNull(saved);
        assertSame(this.StudentRepository, saved);
    }

    @Test
    void read() {
        Student saved = this.SERVICE.save(this.StudentRepository);
        Optional<Student> read = this.SERVICE.read(saved.getStudentID());
        assertAll(
                () -> assertTrue(read.isPresent()),
                () ->assertSame(saved,read.get()));
    }

    @Test
    void delete() {
        Student saved = this.SERVICE.save(this.StudentRepository);
        List<Student> StudentDB= this.SERVICE.findAll();
        assertEquals(1, StudentDB.size());
        this.SERVICE.delete(saved);
        StudentDB= this.SERVICE.findAll();
        assertEquals(0,StudentDB.size());
    }

    @Test
    void findAll() {
        this.SERVICE.save(this.StudentRepository);
        List<Student> StudentDB= this.SERVICE.findAll();
        assertEquals(1,StudentDB.size());
    }
}