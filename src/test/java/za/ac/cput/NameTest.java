package za.ac.cput;



import org.junit.jupiter.api.Test;
import za.ac.cput.school_management.domain.name.Name;


public class NameTest {
    @Test
    public void test(){

        Name name = new Name.Builder().firstName("Smangele")
               .middleName("Witness")
              .lastName("Mabaso")
              .build();
       System.out.println(name);
/*@Test
        public void Builder() {
            Name name = new Name.Builder("Smangele","Witness", "Mabaso");
            Assert.assertNotNull(name.getFirstName());
            System.out.println(name);
        }*/
    }
}
