package za.ac.cput.school_management.service;
/*
Entity for StudentAddress
Chulumanco Buhle Nkwindana
219390983
11 June 2022 */

import java.util.Optional;

public interface IService<T, ID>{
    T save(T t);
    Optional<T> read(ID id);
    void delete(T t);
}
