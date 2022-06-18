/* IEmployeeService.java
   Author: Damone Hartnick
   Student Number : 219093717
   Date: June 2022
*/
package za.ac.cput.service.employee;

import za.ac.cput.domain.employee.Employee;
import za.ac.cput.service.IService;

import java.util.List;
import java.util.Optional;

public interface IEmployeeService extends IService<Employee, String> {

    public List<Employee> findAll();
    List<Employee> findByStaffId( String staffId);

    Optional<Employee> findEmployeeFirstNameByEmail(String email);

    boolean existsByEmail ( String email);

    boolean existsByStaffId( String staffId);
    void deleteById(String id);

    // findByFirstName using employee email
    // check email valid and exist
    // check staffId valid and exist


}
