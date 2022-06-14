package za.ac.cput.school_management.repository;
/*
----------Always add your student number , name and date as a comment before starting------------
 */
import za.ac.cput.school_management.domain.name.Name;

import java.util.Optional;

public interface IRepository<T, ID> {
T save(T t);
Optional<Name> read(ID id);
void delete(T t);

}
