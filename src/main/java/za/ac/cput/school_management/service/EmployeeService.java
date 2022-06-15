/* EmployeeService.java
   Author: Damone Hartnick
   Student Number : 219093717
   Date: June 2022
*/
package za.ac.cput.school_management.service;

import za.ac.cput.school_management.domain.employee.Employee;
import za.ac.cput.school_management.repository.employee.EmployeeRepository;

import java.util.Optional;


public class EmployeeService {

    private final EmployeeRepository repository;
    private static IEmployeeService SERVICE;

    private EmployeeService(){
        this.repository = EmployeeRepository.getRepository();
    }

    public static <ID> IEmployeeService getService() {
        if ( SERVICE == null)
             SERVICE = new IEmployeeService() {
            private IService repository;

                 @Override
                 public Employee save(Employee employee) {
                     return null;
                 }

                 @Override
                 public Optional<Employee> read(String s) {
                     return Optional.empty();
                 }

                 @Override
                 public void delete(Employee employee) {
                    this.repository.delete(employee);

                 }
             };
        return null;
    }





}
