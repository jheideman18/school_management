package za.ac.cput.school_management.repository;

import java.util.Optional;
/*
Entity for StudentAddress
Chulumanco Buhle Nkwindana
219390983
11 June 2022 */
public interface IRepository<T, ID> {
T save(T t);
Optional<T> read(ID id);
void delete(T t);

}
