package za.ac.cput.repository.student;

import za.ac.cput.domain.address.City;
import za.ac.cput.domain.student.Student;

import java.util.*;

/* StudentRepository.Java
 *  Author: Tim Davids 219296219
 *  Entity for Student
 *  June Assignment
 *  Date: 09 June 2022
 * */

public class StudentRepository {
    private static StudentRepository repository;

    private final List<Student> StudentDB;

    private StudentRepository() {
        this.StudentDB = new ArrayList<>();
    }

    public static StudentRepository getRepository() {
        if (repository == null) {
            repository = new StudentRepository();
        }
        return repository;
    }

    public Student save(Student student) {
        Optional<Student> read = read(student.getStudentID());
        if(read.isPresent()){
            delete(read.get());
        }
        this.StudentDB.add(student);
        return student;
    }

    public Optional<Student> read(String studentId) {
        return this.StudentDB.stream().filter(c -> c.getStudentID().equalsIgnoreCase(studentId)).findFirst();
    }
    public void delete(Student student) {
        this.StudentDB.remove(student);

    }
    public List<Student> findAll() {
        return this.StudentDB;
    }
}
