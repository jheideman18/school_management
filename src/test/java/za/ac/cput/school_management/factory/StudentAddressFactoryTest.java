package za.ac.cput.school_management.factory;


import org.junit.jupiter.api.Test;
import za.ac.cput.school_management.domain.StudentAddress;

import static org.junit.jupiter.api.Assertions.*;


public class StudentAddressFactoryTest {
    @Test
    public void buildWithSuccess(){
        StudentAddress studentAddress = StudentAddressFactory
                .build( "219390983", "Zone 9 no 6, Langa, 7455" );
        System.out.println(studentAddress);
        assertNotNull(studentAddress);
    }

    @Test
    public void buildWithError(){
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                StudentAddressFactory
                        .build( null, "Zone 9 no 6,Langa,7455"));

        String exceptionMessage = exception.getMessage();
        System.out.println(exceptionMessage);
        assertSame( "The student ID is required", exceptionMessage);
    }
}
