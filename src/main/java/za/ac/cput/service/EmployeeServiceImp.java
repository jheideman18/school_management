/* EmployeeServiceImp.java
   Author: Damone Hartnick
   Student Number : 219093717
   Date: June 2022
*/
package za.ac.cput.service;

import org.springframework.stereotype.Service;
import za.ac.cput.domain.employee.Employee;
import za.ac.cput.repository.employee.EmployeeRepository;

import java.util.List;
import java.util.Optional;


@Service
public class EmployeeServiceImp implements IEmployeeService {

    private final EmployeeRepository repository;
    private static IEmployeeService SERVICE ;

    private EmployeeServiceImp(){
        this.repository = EmployeeRepository.getRepository();
    }

    public static EmployeeServiceImp getService() {
            if(SERVICE == null)
                SERVICE = new EmployeeServiceImp();
        return (EmployeeServiceImp) SERVICE;
    }


    @Override
    public Employee save(Employee employee) {
        return this.repository.save(employee);
    }

    @Override
    public Optional<Employee> read(String s) {
        return this.repository.read(s);
    }

    @Override
    public void delete(Employee employee) {
        this.repository.delete(employee);

    }

    // List of all Employees
    @Override
    public List<Employee> findAll() {
        return this.repository.findAll();
    }

    // Finds employees by staffId
    @Override
    public List<Employee> findByStaffId(String staffId) {
        return this.repository.findByStaffId(staffId);
    }

     // Finds EmployeeFirstname by their email
    @Override
    public Optional<Employee> findEmployeeFirstNameByEmail(String email) {
        return this.repository.findEmployeeFirstNameByEmail(email);
    }


    // Checks if email valid and exist
    // true = exist
    // false = doesn't exist or not valid
    @Override
    public boolean existsByEmail(String email) {
        return this.repository.existsByEmail(email);
    }

    // Checks if staffId valid and exist
    // true = exist
    // false = doesn't exist or not valid
    @Override
    public boolean existsByStaffId(String staffId) {
        return this.repository.existsByStaffId( staffId);
    }


}
