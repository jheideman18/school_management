package za.ac.cput.FactoryTest;
/* StudentFactoryTest.Java
 *  Author: Tim Davids 219296219
 *  Entity for Student
 *  June Assignment
 *  Date: 09 June 2022
 * */

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.name.Name;
import za.ac.cput.domain.student.Student;
import za.ac.cput.factory.name.NameFactory;
import za.ac.cput.factory.student.StudentFactory;

import static org.junit.jupiter.api.Assertions.*;

class StudentFactoryTest {
    Name name = NameFactory.build("Damone","Dale","Hen");
    @Test
    void buildWithError(){
        Exception exception = assertThrows(IllegalArgumentException.class,() ->
                StudentFactory.build(null,"219296219@mycput.ac.za",name));
        String exceptionMessage = exception.getMessage();
        System.out.println(exceptionMessage);
        assertEquals("Invalid value for param: null", exceptionMessage);
    }

    @Test
    void buildWithSuccess(){
        Student Student = StudentFactory
                .build("219296219","219296219@mycput.ac.za",name);
        System.out.println(Student);
        assertAll(
                () -> assertNotNull(Student)
        );
    }
}
