//package za.ac.cput.school_management.test.serviceTest;
//
//import org.junit.Test;
//import za.ac.cput.school_management.domain.name.Name;
//import za.ac.cput.school_management.factory.name.NameFactory;
//import za.ac.cput.school_management.service.name.impl.NameService;
//import java.util.Set;
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertTrue;
//
//
//public class NameServiceTest {
//
//    private NameService nameService;
//    private static Name name = NameFactory.build("Smangele", "Witness","Mabaso");
//
//    @Test
//    public void getAll() {
//        Set<Name> name = nameService.getAll();
//        assertEquals(1,name.size());
//        System.out.println("all Names: " + name);
//    }
//
//    @Test
//    public void create() {
//        Name created = nameService.create(name);
//        assertEquals(name.getFirstName(),created.getFirstName());
//        System.out.println(("Created: " + created));
//    }
//
//    @Test
//    public void read() {
//        Name read = nameService.read(name.getFirstName());
//        System.out.println("Read:" + read);
//    }
//
//    @Test
//    public void update() {
//        Name updated = new Name.Builder()
//                .copy(name).build();
//        updated= nameService.update(updated);
//        System.out.println("Update: " + updated);
//    }
//
//    @Test
//    public void delete() {
//        boolean deleted = nameService.delete(name.getFirstName());
//        assertTrue(deleted);
//
//    }
//}

