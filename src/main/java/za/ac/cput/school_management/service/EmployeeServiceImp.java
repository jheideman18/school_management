/* EmployeeServiceImp.java
   Author: Damone Hartnick
   Student Number : 219093717
   Date: June 2022
*/
package za.ac.cput.school_management.service;

import za.ac.cput.school_management.domain.employee.Employee;
import za.ac.cput.school_management.repository.employee.EmployeeRepository;

import java.util.List;
import java.util.Optional;



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

    @Override
    public List<Employee> findAll() {
        return this.repository.findAll();
    }

    @Override
    public List<Employee> findByStaffId(String staffId) {
        return this.repository.findByStaffId(staffId);
    }
}
