package za.ac.cput.service;
/* IStudentService.Java
 *  Author: Tim Davids 219296219
 *  Entity for Student
 *  June Assignment
 *  Date: 09 June 2022
 * */
import za.ac.cput.domain.student.Student;

import java.util.List;

public interface IStudentService extends IService<Student, String> {
    List<Student> findAll();
}
