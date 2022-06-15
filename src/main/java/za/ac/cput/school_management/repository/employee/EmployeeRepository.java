/* EmployeeRepository.java
   Author: Damone Hartnick
   Student Number : 219093717
   Date: June 2022
*/
package za.ac.cput.school_management.repository.employee;

import za.ac.cput.school_management.domain.employee.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EmployeeRepository  {

    private static EmployeeRepository repository;

    private final List<Employee> EmployeeBD;

    private EmployeeRepository() {
       this.EmployeeBD = new ArrayList<>();
    }

    public static  EmployeeRepository getRepository(){
        if (repository == null) {
            repository = new EmployeeRepository();

        }
         return repository;
    }

    public Employee save ( Employee employee) {
        Optional<Employee> read = read (employee.getStaffId(), employee.getEmail());
        if(read.isPresent()){
            delete(read.get());
        }
        this.EmployeeBD.add(employee);
        return employee;
    }

    private Optional<Employee> read(String staffId, String email) {
        return this.EmployeeBD.stream().filter(g -> g.getStaffId().equalsIgnoreCase(staffId))
                .filter(g -> g.getEmail().equalsIgnoreCase(email))
                .findFirst();
    }

    public void delete( Employee employee){
        this.EmployeeBD.remove(employee);
    }

    public List<Employee> getAll() {
        return this.EmployeeBD;
    }

}
