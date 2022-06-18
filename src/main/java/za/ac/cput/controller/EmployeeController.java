/* EmployeeController.java
   Author: Damone Hartnick
   Student Number : 219093717
   Date: June 2022
*/

package za.ac.cput.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.domain.employee.Employee;
import za.ac.cput.service.EmployeeServiceImp;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("school_management/employee/")
@Slf4j

public class EmployeeController {

    private final EmployeeServiceImp employeeServiceImp;

    @Autowired
    public EmployeeController(EmployeeServiceImp employeeServiceImp) {
        this.employeeServiceImp = employeeServiceImp;
    }

    @PostMapping("save")
    public ResponseEntity<Employee> save(@Valid @RequestBody Employee employee){
        log.info("Save request: {}", employee);
        Employee saved = employeeServiceImp.save(employee);
        return ResponseEntity.ok(saved);
    }

    @GetMapping("read/{staffId}")
    public ResponseEntity<Employee> read(@PathVariable String staffId){
        Employee employee = this.employeeServiceImp.read(staffId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee not found"));
        return ResponseEntity.ok(employee);
    }

    @DeleteMapping("delete/{staffId}")
    public ResponseEntity<Void> delete(@PathVariable Employee employee)
    {
        log.info("Delete request: {}", employee);
        this.employeeServiceImp.delete(employee);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("findAll")
    public ResponseEntity<List<Employee>> findAll(){
        List<Employee> employeeList = this.employeeServiceImp.findAll();
        return ResponseEntity.ok(employeeList);
    }

    @GetMapping("findByStaffId")
    public ResponseEntity<List<Employee>> findByStaffId(@PathVariable String staffId){
        log.info(" Find request: {}" , staffId);
        List<Employee> employeeList = this.employeeServiceImp.findByStaffId(staffId);
        return ResponseEntity.ok(employeeList);

    }

    @GetMapping("findEmployeeFirstNameByEmail")
    public ResponseEntity<Optional<Employee>> findEmployeeFirstNameByEmail(@PathVariable String email) {
        log.info(" Find request : {}" , email );
        Optional<Employee> employeeOptional = this.employeeServiceImp.findEmployeeFirstNameByEmail(email);
        return ResponseEntity.ok(employeeOptional);

    }

    @GetMapping("findAllEmployeeFirstNamesByCity")
    public ResponseEntity<List <Employee>> findAllEmployeeFirstNamesByCity(@PathVariable String cityId){
        log.info(" Find request : {}" , cityId );
        List<Employee> employeeList = this.employeeServiceImp.findAllEmployeeFirstNamesByCity(cityId);
        return ResponseEntity.ok(employeeList);

    }


}
