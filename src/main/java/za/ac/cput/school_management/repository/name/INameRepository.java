package za.ac.cput.school_management.repository.name;

import za.ac.cput.school_management.domain.name.Name;
import za.ac.cput.school_management.repository.IRepository;

import java.util.Set;

public interface INameRepository extends IRepository<Name, String> {
    Name update(Name name);
    Set<Name> findAll();
}
