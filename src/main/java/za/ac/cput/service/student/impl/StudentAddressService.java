package za.ac.cput.service.student.impl;

import za.ac.cput.domain.student.StudentAddress;
import za.ac.cput.repository.student.StudentAddressRepository;
import za.ac.cput.service.student.IStudentAddressService;

import java.util.List;
import java.util.Optional;

/*
Entity for StudentAddress
Chulumanco Buhle Nkwindana
219390983
11 June 2022 */

public class StudentAddressService implements IStudentAddressService {

    private final StudentAddressRepository repository;
    private static IStudentAddressService SERVICE;

    private StudentAddressService(){
        this.repository = StudentAddressRepository.studentAddressRepository();
    }

    public static IStudentAddressService getService(){
        if (SERVICE == null)
            SERVICE = new StudentAddressService();
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
    @Override
    public List<StudentAddress> findAll() {
        return this.repository.findAll();
    }
}
