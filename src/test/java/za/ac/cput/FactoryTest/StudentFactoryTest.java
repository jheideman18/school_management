package za.ac.cput.FactoryTest;
/* StudentFactoryTest.Java
 *  Author: Tim Davids 219296219
 *  Entity for Student
 *  June Assignment
 *  Date: 09 June 2022
 * */

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.student.Student;
import za.ac.cput.factory.student.StudentFactory;

import static org.junit.jupiter.api.Assertions.*;

class StudentFactoryTest {

    @Test
    void buildWithError(){
        Exception exception = assertThrows(IllegalAccessException.class,() ->
                StudentFactory.build("","",""));
        System.out.println(exception.getMessage());
        assertTrue(exception.getMessage().contains("StudentID"));
    }

    @Test
    void buildWithSuccess(){
        Student student = StudentFactory
                .build("219296219","219296219@mycput.ac.za","Tim");
        System.out.println(student);
        assertAll(
                () -> assertNotNull(student)
        );
    }
}
