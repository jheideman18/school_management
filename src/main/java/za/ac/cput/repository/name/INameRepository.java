package za.ac.cput.repository.name;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.name.Name;
import za.ac.cput.repository.IRepository;

import java.util.List;

@Repository
public interface INameRepository extends JpaRepository<Name, String> {

    List<Name> findAll();
}
