package za.ac.cput.repository.name;



import za.ac.cput.domain.name.Name;
import za.ac.cput.repository.IRepository;

import java.util.List;


public interface INameRepository extends IRepository<Name, String> {

    List<Name> findAll();
}
