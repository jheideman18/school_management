package za.ac.cput.service.student;
/*
Entity for StudentAddress
Chulumanco Buhle Nkwindana
219390983
11 June 2022 */
import za.ac.cput.domain.student.StudentAddress;
import za.ac.cput.service.IService;

import java.util.List;

public interface IStudentAddressService extends IService<StudentAddress, String> {
    List<StudentAddress> findAll();
}
