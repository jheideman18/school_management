package za.ac.cput.RespositoryTest;
/* NameRepositoryTest.java
 * Author: Smangele Witness Mabaso (220047154)
 * Date: 14 June 2022
 */
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.name.Name;
import za.ac.cput.factory.name.NameFactory;
import za.ac.cput.repository.name.NameRepository;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;


public class NameRepositoryTest {

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
    @Test
    public void save() {
        Name saved = this.repository.save(this.name);
        assertNotNull(saved);
        assertSame(this.name, saved);

    }

    @Test
    public void read() {
        Name saved = this.repository.save(this.name);
        Optional<Name> read = this.repository.read(saved.getFirstName());
        assertAll(

                () -> assertTrue(read.isPresent()),
                () -> assertSame(saved, read.get())
        );
    }

    @Test
    public void delete() {
        Name saved = this.repository.save(this.name);
        List<Name> nameList = this.repository.findAll();
        assertEquals(1, nameList.size());
        this.repository.delete(this.name);
        nameList = this.repository.findAll();
        assertEquals(0, nameList.size());
    }

    @Test
    public void findAll(){
        this.repository.save(this.name);
        List<Name> nameList = this.repository.findAll();
        assertEquals(1, nameList.size());
    }
}

