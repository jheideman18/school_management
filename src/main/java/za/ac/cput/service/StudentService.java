package za.ac.cput.service;

import za.ac.cput.domain.student.Student;
import za.ac.cput.repository.student.StudentRepository;

import java.util.Optional;
/* StudentService.Java
 *  Author: Tim Davids 219296219
 *  Entity for Student
 *  June Assignment
 *  Date: 09 June 2022
 * */
public class StudentService implements IStudentService{
    private final StudentRepository repository;
    private static IStudentService SERVICE;

    private StudentService(){
        this.repository = StudentRepository.getRepository();
    }
    public static IStudentService getService() {
        if (SERVICE == null)
            SERVICE = new StudentService();
        return SERVICE;
            }

    @Override
    public Student save(Student student) {
        return this.repository.save(student);
    }

    @Override
    public Optional<Student> read(String s) {
        return null;
    }

    @Override
    public void delete(Student student) {
        this.repository.delete(student);

    }
}


