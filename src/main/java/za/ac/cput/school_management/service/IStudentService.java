package za.ac.cput.school_management.service;
/* IStudentService.Java
 *  Author: Tim Davids 219296219
 *  Entity for Student
 *  June Assignment
 *  Date: 09 June 2022
 * */
import za.ac.cput.school_management.domain.student.Student;
import za.ac.cput.school_management.service.IService;

import java.util.List;

public interface IStudentService extends IService<Student, String> {
    List<Student> findAll();
}
