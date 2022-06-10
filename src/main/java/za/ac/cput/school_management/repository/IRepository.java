package za.ac.cput.school_management.repository;
/*
----------Always add your student number , name and date as a comment before starting------------
 */
import java.util.Optional;

public interface IRepository<T, ID> {
T save(T t);
Optional<T> read(ID id);
void delete(T t);

}
