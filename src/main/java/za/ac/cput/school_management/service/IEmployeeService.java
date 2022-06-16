/* IEmployeeService.java
   Author: Damone Hartnick
   Student Number : 219093717
   Date: June 2022
*/
package za.ac.cput.school_management.service;

import za.ac.cput.school_management.domain.employee.Employee;
import za.ac.cput.school_management.service.IService;

import java.util.List;

public interface IEmployeeService extends IService<Employee, String> {

    public List<Employee> findAll();
    List<Employee> findByStaffId( String staffId);


}
