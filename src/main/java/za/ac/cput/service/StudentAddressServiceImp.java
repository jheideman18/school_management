package za.ac.cput.service;

import za.ac.cput.domain.student.StudentAddress;
import za.ac.cput.repository.student.StudentAddressRepository;
import za.ac.cput.repository.student.StudentAddressRepositoryImp;

import java.util.Optional;

/*
Entity for StudentAddress
Chulumanco Buhle Nkwindana
219390983
11 June 2022 */
public class StudentAddressServiceImp implements StudentAddressService{
    private final StudentAddressRepository repository;
    private static StudentAddressService SERVICE;

    private StudentAddressServiceImp(){
        this.repository = StudentAddressRepositoryImp.studentAddressRepository();
    }

    public static StudentAddressService getService(){
        if (SERVICE == null)
            SERVICE = new StudentAddressServiceImp();
        return SERVICE;
    }


    @Override
    public StudentAddress save(StudentAddress studentAddress) {
        return this.repository.save(studentAddress);
    }

    @Override
    public Optional<StudentAddress> read(String s) {
        return this.repository.read(s);
    }

    @Override
    public void delete(StudentAddress studentAddress) {
        this.repository.delete(studentAddress);

    }
}
