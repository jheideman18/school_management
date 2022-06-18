package za.ac.cput.ServiceTest;
/*  NameServiceTest.java
 * Author: Smangele Witness Mabaso (220047154)
 *
 */
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.name.Name;
import za.ac.cput.factory.name.NameFactory;
import za.ac.cput.service.name.impl.NameService;

import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertSame;


public class NameServiceTest {

        private NameService service;
        private Name name;


        @BeforeEach
        void setUp(){
            this.name = NameFactory.build("Smangele", "Witness", "Mabaso");
            this.service = NameService.getService();
        }

        @AfterEach
        void tearDown(){
            this.service.delete(this.name);

        }
        @org.junit.jupiter.api.Test
        public void save() {
            Name saved = this.service.save(this.name);
            assertNotNull(saved);
            assertSame(this.name, saved);

        }

        @org.junit.jupiter.api.Test
        public void read() {
            Name saved = this.service.save(this.name);
            Optional<Name> read = this.service.read(saved.getFirstName());
            assertAll(

                    () -> Assertions.assertTrue(read.isPresent()),
                    () -> assertSame(saved, read.get())
            );
        }

        @org.junit.jupiter.api.Test
        public void delete() {
            Name saved = this.service.save(this.name);
            List<Name> nameList = this.service.findAll();
            Assertions.assertEquals(1, nameList.size());
            this.service.delete(this.name);
            nameList = this.service.findAll();
            Assertions.assertEquals(0, nameList.size());
        }

        @Test
        public void findAll() {
            this.service.save(this.name);
            List<Name> nameList = this.service.findAll();
            Assertions.assertEquals(1, nameList.size());
        }
}

