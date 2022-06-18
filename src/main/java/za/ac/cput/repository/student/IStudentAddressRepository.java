package za.ac.cput.repository.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.student.StudentAddress;
import za.ac.cput.repository.IRepository;

import java.util.List;
/*
Entity for StudentAddress
Chulumanco Buhle Nkwindana
219390983
11 June 2022 */

public interface IStudentAddressRepository extends IRepository<StudentAddress, String> {


}
