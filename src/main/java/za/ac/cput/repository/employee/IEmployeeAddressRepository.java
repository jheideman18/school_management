package za.ac.cput.repository.employee;
/*  IEmployeeAddressRepository.Java
 *  Entity for IEmployeeAddressRepository
 *  Author: Yasmeen Nel (219250553)
 *  Date: 13 June 2022
 * */

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.domain.employee.EmployeeAddress;
import za.ac.cput.repository.IRepository;

import java.util.List;

public interface IEmployeeAddressRepository extends JpaRepository<EmployeeAddress, String> {
    List<EmployeeAddress> getAll();
}

