package za.ac.cput.service.employee;
/*  IEmployeeAddressService.Java
 *  Entity for IEmployeeAddressService
 *  Author: Yasmeen Nel (219250553)
 *  Date: 14 June 2022
 * */
import za.ac.cput.domain.employee.EmployeeAddress;
import za.ac.cput.service.IService;

import java.util.List;

public interface IEmployeeAddressService extends IService<EmployeeAddress, String> {
    List<EmployeeAddress> getAll();
}
