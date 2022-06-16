package za.ac.cput.school_management.repository.name;

import za.ac.cput.school_management.domain.name.Name;
import za.ac.cput.school_management.repository.IRepository;
import java.util.List;


public interface INameRepository extends IRepository<Name, String> {

    List<Name> findAll();
}
