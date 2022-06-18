
package za.ac.cput.controller;
/*
Damone Hartnick 219093717
Smangele Witness Mabaso 220047154
EmployeeController.java
 */

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.domain.employee.Employee;
import za.ac.cput.service.employee.impl.EmployeeService;
import za.ac.cput.service.employee.IEmployeeService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("school/employee/")
@Slf4j

public class EmployeeController {

    private final IEmployeeService iEmployeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.iEmployeeService = employeeService;
    }

    @PostMapping("save")
    public ResponseEntity<Employee> save(@Valid @RequestBody Employee employee){
        log.info("Save request: {}", employee);
        Employee saved = iEmployeeService.save(employee);
        return ResponseEntity.ok(saved);
    }

    @GetMapping("read/{staffId}")
    public ResponseEntity<Employee> read(@PathVariable String staffId){
        Employee employee = this.iEmployeeService.read(staffId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee not found"));
        return ResponseEntity.ok(employee);
    }

    @DeleteMapping("delete/{staffId}")
    public ResponseEntity<Void> delete(@PathVariable String id)
    {
        log.info("Delete request: {}", id);
        this.iEmployeeService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("findAll")
    public ResponseEntity<List<Employee>> findAll(){
        List<Employee> employeeList = this.iEmployeeService.findAll();
        return ResponseEntity.ok(employeeList);
    }

    @GetMapping("findByStaffId")
    public ResponseEntity<List<Employee>> findByStaffId(@PathVariable String staffId){
        log.info(" Find request: {}" , staffId);
        List<Employee> employeeList = this.iEmployeeService.findByStaffId(staffId);
        return ResponseEntity.ok(employeeList);

    }

    @GetMapping("findEmployeeFirstNameByEmail")
    public ResponseEntity<Optional<Employee>> findEmployeeFirstNameByEmail(@PathVariable String email) {
        log.info(" Find request : {}" , email );
        Optional<Employee> employeeOptional = this.iEmployeeService.findEmployeeFirstNameByEmail(email);
        return ResponseEntity.ok(employeeOptional);

    }


}
