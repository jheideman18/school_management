package za.ac.cput.repository.student;
/* IStudentRepository.Java
 *  Author: Tim Davids 219296219
 *  Entity for Student
 *  June Assignment
 *  Date: 09 June 2022
 * */

import za.ac.cput.domain.student.Student;
import za.ac.cput.repository.IRepository;

import java.util.List;

public interface IStudentRepository extends IRepository<Student, String> {

    List<Student> getAll();
}
