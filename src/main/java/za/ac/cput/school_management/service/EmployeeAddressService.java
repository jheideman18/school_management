package za.ac.cput.school_management.service;
/*  EmployeeAddressService.Java
 *  Entity for EmployeeAddressService
 *  Author: Yasmeen Nel (219250553)
 *  Date: 13 June 2022
 * */

import za.ac.cput.school_management.domain.employee.EmployeeAddress;
import za.ac.cput.school_management.repository.employee.EmployeeAddressRepository;
import za.ac.cput.school_management.repository.employee.IEmployeeAddressRepository;

import java.util.Optional;

public class EmployeeAddressService implements IEmployeeAddressService {
    private final IEmployeeAddressRepository repository;
    private static EmployeeAddressService SERVICE;

    private EmployeeAddressService(){this.repository = EmployeeAddressRepository.getRepository();}

    public static EmployeeAddressService getService(){
        if (SERVICE == null)
            SERVICE = new EmployeeAddressService();
        return SERVICE;
    }

    @Override
    public EmployeeAddress save(EmployeeAddress employeeAddress) {
        return this.repository.save(employeeAddress);
    }

    @Override
    public Optional<EmployeeAddress> read(String s) {
        return this.repository.read(s);
    }

    @Override
    public void delete(EmployeeAddress employeeAddress) {
        this.repository.delete(employeeAddress);
    }
}

