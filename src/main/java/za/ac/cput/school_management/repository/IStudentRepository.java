package za.ac.cput.school_management.repository;
/* IStudentRepository.Java
 *  Author: Tim Davids 219296219
 *  Entity for Student
 *  June Assignment
 *  Date: 09 June 2022
 * */

import za.ac.cput.school_management.domain.Student;

import java.util.List;

public interface IStudentRepository extends IRepository<Student, String> {


    List<Student> getAll();
}
