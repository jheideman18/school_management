package za.ac.cput.ServiceTest;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.school_management.domain.name.Name;
import za.ac.cput.school_management.factory.name.NameFactory;
import za.ac.cput.school_management.repository.name.impl.NameRepository;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertSame;


public class NameServiceTest {

        private NameRepository repository;
        private Name name;


        @BeforeEach
        void setUp(){
            this.name = NameFactory.build("Smangele", "Witness", "Mabaso");
            this.repository = NameRepository.nameRepository();
        }

        @AfterEach
        void tearDown(){
            this.repository.delete(this.name);

        }
        @org.junit.jupiter.api.Test
        public void save() {
            Name saved = this.repository.save(this.name);
            assertNotNull(saved);
            assertSame(this.name, saved);

        }

        @org.junit.jupiter.api.Test
        public void read() {
            Name saved = this.repository.save(this.name);
            Optional<Name> read = this.repository.read(saved.getFirstName());
            assertAll(

                    () -> Assertions.assertTrue(read.isPresent()),
                    () -> assertSame(saved, read.get())
            );
        }

        @org.junit.jupiter.api.Test
        public void delete() {
            Name saved = this.repository.save(this.name);
            List<Name> nameList = this.repository.findAll();
            Assertions.assertEquals(1, nameList.size());
            this.repository.delete(this.name);
            nameList = this.repository.findAll();
            Assertions.assertEquals(0, nameList.size());
        }

        @Test
        public void findAll() {
            this.repository.save(this.name);
            List<Name> nameList = this.repository.findAll();
            Assertions.assertEquals(1, nameList.size());
        }
}

