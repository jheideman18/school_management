package za.ac.school_management.FactoryTest;


import org.junit.jupiter.api.Test;
import za.ac.cput.school_management.domain.name.Name;
import za.ac.cput.school_management.factory.name.NameFactory;

import static org.junit.jupiter.api.Assertions.*;


public class NameFactoryTest {
    @Test
    public void build() {
        Name name = NameFactory.build("Smangele","Witness", "Mabaso");
        System.out.println(name);

        assertNotNull(name);

    }

    @Test
    public void buildWithError(){

        Exception exception = assertThrows(IllegalArgumentException.class, () ->
        NameFactory.build(null,"Witness", "Mabaso"));
        String exceptionMessage = exception.getMessage();
        System.out.println(exceptionMessage);
        assertSame("firstName is required", exceptionMessage);

    }
}
