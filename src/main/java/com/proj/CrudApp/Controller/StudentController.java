package com.proj.CrudApp.Controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.proj.CrudApp.Students;
import com.proj.CrudApp.Service.StudentService;

@RestController
@RequestMapping("/Students") // Controller for specially "/Students" Route

public class StudentController {
    @Autowired
    StudentService studentService;

    @GetMapping("/getAll")
    public ResponseEntity<List<Students>> getStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/course/{course}")
    public ResponseEntity<List<Students>> getStudentByCourse(@PathVariable String course) {
        return studentService.getStudentByCourse(course);
    }

    @PostMapping("/AddStudent")
    public ResponseEntity<String> addStudent(@RequestBody Students students) {
        return studentService.addStudent(students);
    }

    @PutMapping("/UpdateStudent")
    public ResponseEntity<String> updateStudent(@RequestBody Students students, @RequestParam int Id) {
        return studentService.updateStudent(Id, students);
    }

    @DeleteMapping("/DeleteStudent")
    public ResponseEntity<String> deleteStudent(@RequestParam int Id) {
        return studentService.deleteStudent(Id);
    }

}
