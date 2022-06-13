package za.ac.cput.school_management.repository;

import za.ac.cput.school_management.domain.StudentAddress;

import java.util.List;
/*
Entity for StudentAddress
Chulumanco Buhle Nkwindana
219390983
11 June 2022 */

public interface StudentAddressRepository extends IRepository<StudentAddress, String>{
    List<StudentAddress> findAll();

}
