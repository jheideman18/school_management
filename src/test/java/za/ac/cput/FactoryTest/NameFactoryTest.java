package za.ac.cput.FactoryTest;
/* NameFactoryTest.java
 * Author: Smangele Witness Mabaso (220047154)
 * Date: 14 June 2022
 */

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.name.Name;
import za.ac.cput.factory.name.NameFactory;

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
