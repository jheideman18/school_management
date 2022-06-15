package za.ac.cput.school_management.repository.student;

import za.ac.cput.school_management.domain.student.Student;

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
        Optional<Student> read = read(student.getStudentID(), student.getStudentemail());
        if (read.isPresent()){
            delete(read.get());
        }
        this.StudentDB.add(student);
    return student;
    }

    public Optional<Student> read(String StudentID, String Studentemail) {
        return this.StudentDB.stream().filter(g -> g.getStudentID().equalsIgnoreCase(StudentID))
                .filter(g -> g.getStudentemail().equalsIgnoreCase(Studentemail))
                .findFirst();
    }
    public void delete(Student student) {
        this.StudentDB.remove(student);

    }
    public List<Student> getAll() {
        return this.StudentDB;
    }
}