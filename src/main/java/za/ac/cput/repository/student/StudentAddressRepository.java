package za.ac.cput.repository.student;

import za.ac.cput.domain.student.StudentAddress;
import za.ac.cput.repository.IRepository;

import java.util.List;
/*
Entity for StudentAddress
Chulumanco Buhle Nkwindana
219390983
11 June 2022 */

public interface StudentAddressRepository extends IRepository<StudentAddress, String> {
    List<StudentAddress> findAll();

}
