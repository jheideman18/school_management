package za.ac.cput.service.employee.impl;
/*  EmployeeAddressService.Java
 *  Entity for EmployeeAddressService
 *  Author: Yasmeen Nel (219250553)
 *  Date: 13 June 2022
 * */

import za.ac.cput.domain.employee.EmployeeAddress;
import za.ac.cput.repository.employee.EmployeeAddressRepository;
import za.ac.cput.service.employee.IEmployeeAddressService;

import java.util.List;
import java.util.Optional;

public class EmployeeAddressService implements IEmployeeAddressService {
    private final EmployeeAddressRepository repository;
    private static IEmployeeAddressService SERVICE;

    private EmployeeAddressService(){this.repository =EmployeeAddressRepository.getRepository();}

    public static IEmployeeAddressService getService(){
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

    @Override
    public List<EmployeeAddress> getAll() {
        return this.repository.getAll();
    }

}

