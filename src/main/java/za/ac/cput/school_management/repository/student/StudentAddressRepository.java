package za.ac.cput.school_management.repository.student;

import za.ac.cput.school_management.domain.student.StudentAddress;
import za.ac.cput.school_management.repository.IRepository;

import java.util.List;
/*
Entity for StudentAddress
Chulumanco Buhle Nkwindana
219390983
11 June 2022 */

public interface StudentAddressRepository extends IRepository<StudentAddress, String> {
    List<StudentAddress> findAll();

}
