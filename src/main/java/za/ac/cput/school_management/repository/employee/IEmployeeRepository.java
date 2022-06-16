/* IEmployeeRepository.java
   Author: Damone Hartnick
   Student Number : 219093717
   Date: June 2022
*/
package za.ac.cput.school_management.repository.employee;

import za.ac.cput.school_management.domain.employee.Employee;
import za.ac.cput.school_management.repository.IRepository;

import java.util.List;

public interface IEmployeeRepository extends IRepository<Employee, String> {

    public List<Employee> findAll();
    public List<Employee> findByStaffId( String staffId);



}
