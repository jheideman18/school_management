/* IEmployeeRepository.java
   Author: Damone Hartnick
   Student Number : 219093717
   Date: June 2022
*/
package za.ac.cput.repository.employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.employee.Employee;
import za.ac.cput.repository.IRepository;

import java.util.List;
import java.util.Optional;


public interface IEmployeeRepository extends JpaRepository<Employee, String> {

    public List<Employee> findAll();
    public List<Employee> findByStaffId( String staffId);
    Optional<Employee> findEmployeeFirstNameByEmail(String email);
    boolean existsByEmail ( String email);
    boolean existsByStaffId( String staffId);

}
