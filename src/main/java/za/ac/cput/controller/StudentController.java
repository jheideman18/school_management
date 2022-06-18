package za.ac.cput.controller;
/*
Tim Davids 219296219
Yasmeen Nel 219250553
StudentController.java

 */
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.domain.student.Student;
import za.ac.cput.service.student.IStudentService;

import javax.validation.Valid;
import java.util.List;
@RestController
@RequestMapping("school/student/")
@Slf4j
public class StudentController {

    private final IStudentService iStudentService;

    @Autowired
    public StudentController( IStudentService iStudentService){
        this.iStudentService = iStudentService;
    }
    @PostMapping("save")
    public ResponseEntity<Student> save(@Valid @RequestBody Student student){
        log.info("Save request: {}", student);
        Student saved = iStudentService.save(student);
        return ResponseEntity.ok(saved);
    }

    @GetMapping("read/{id}")
    public ResponseEntity<Student> read(@PathVariable String id){
        Student student = this.iStudentService.read(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Student not found"));
        return ResponseEntity.ok(student);
    }
    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id){
        log.info("Save request: {}", id);
        this.iStudentService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("findAll")
    public ResponseEntity<List<Student>> findAll(){
        //log.info("Save request: {}", city);
        List<Student> studentList = this.iStudentService.findAll();
        return ResponseEntity.ok(studentList);
    }
}
