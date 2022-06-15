package za.ac.cput.school_management.repository.student;

import za.ac.cput.school_management.domain.student.StudentAddress;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/*
Entity for StudentAddress
Chulumanco Buhle Nkwindana
219390983
11 June 2022 */

public class StudentAddressRepositoryImp implements StudentAddressRepository {
    private final List<StudentAddress> studentAddressList;
    private static StudentAddressRepositoryImp STUDENTADDRESS_REPOSITORY;

    private StudentAddressRepositoryImp(){
        this.studentAddressList = new ArrayList<>();
    }

    public static StudentAddressRepositoryImp studentAddressRepository(){
        if (STUDENTADDRESS_REPOSITORY == null)
            STUDENTADDRESS_REPOSITORY = new StudentAddressRepositoryImp();
        return STUDENTADDRESS_REPOSITORY;
    }


    public StudentAddress save(StudentAddress studentAddress){
        Optional<StudentAddress> read = read(studentAddress.getStudentID());
        if (read.isPresent()){
            delete(read.get());
    }
        this.studentAddressList.add(studentAddress);
        return studentAddress;
    }


    public Optional<StudentAddress> read(String studentID){
        return this.studentAddressList.stream().filter(g-> g.getStudentID().equalsIgnoreCase(studentID))
                .findFirst();
    }

    public void delete(StudentAddress studentAddress){
        this.studentAddressList.remove(studentAddress);
    }

    public List<StudentAddress> findAll(){
        return this.studentAddressList;

    }
}
