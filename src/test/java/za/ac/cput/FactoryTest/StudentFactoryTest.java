package za.ac.cput.FactoryTest;
/* StudentFactoryTest.Java
 *  Author: Tim Davids 219296219
 *  Entity for Student
 *  June Assignment
 *  Date: 09 June 2022
 * */

import org.junit.jupiter.api.Test;
import za.ac.cput.school_management.domain.student.Student;
import za.ac.cput.school_management.factory.student.StudentFactory;

import static org.junit.jupiter.api.Assertions.*;

class StudentFactoryTest {

    @Test
    void buildWithError(){
        Exception exception = assertThrows(IllegalArgumentException.class,() ->
                StudentFactory.build(null,"",""));
        String exceptionMessage = exception.getMessage();
        System.out.println(exceptionMessage);
        assertSame("StudentID required", exceptionMessage);
    }

    @Test
    void buildWithSuccess(){
        Student Student = StudentFactory
                .build("219296219","219296219@mycput.ac.za","Tim");
        System.out.println(Student);
        assertAll(
                () -> assertNotNull(Student)
        );
    }
}
