package com.proj.CrudApp.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.proj.CrudApp.Students;
import com.proj.CrudApp.dao.StudentDAO;

@Service
public class StudentService {
    @Autowired
    StudentDAO studentDAO;

    public ResponseEntity<List<Students>> getAllStudents() {
        try {
            return new ResponseEntity<>(studentDAO.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<List<Students>> getStudentByCourse(String course) {
        try {
            return new ResponseEntity<>(studentDAO.findByCourse(course), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<String> addStudent(Students newStudent) {
        try {
            studentDAO.save(newStudent);
            return new ResponseEntity<>("Successfully Added", HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>("Failed In Adding", HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<String> deleteStudent(int id) {
        try {
            if (id > 0) {
                Optional<Students> std = studentDAO.findById(id);
                if (std.isPresent()) {
                    studentDAO.deleteById(id);
                    return new ResponseEntity<>("Successfully Deleted", HttpStatus.OK);
                } else {
                    return new ResponseEntity<>("Student Not Found", HttpStatus.NOT_FOUND);
                }
            } else {
                return new ResponseEntity<>("Id is Invalid", HttpStatus.UNPROCESSABLE_ENTITY);
            }   

        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>("Failed In Deleting", HttpStatus.BAD_REQUEST);

    }

    public ResponseEntity<String> updateStudent(int id, Students updatedStudent) {
        try {
            if (id > 0) {
                Optional<Students> stud = studentDAO.findById(id);
                if (stud.isPresent()) {
                    Students student = stud.get();
                    student.setName(updatedStudent.getName());
                    student.setPhone_number(updatedStudent.getPhone_number());
                    student.setCourse(updatedStudent.getCourse());
                    student.setAddress(updatedStudent.getAddress());
                    student.setFees(updatedStudent.getFees());
                    studentDAO.save(student);
                    return new ResponseEntity<>("Successfully Updated", HttpStatus.OK);
                } else {
                    return new ResponseEntity<>("Student NOT Found", HttpStatus.NOT_FOUND);
                }
            } else {
                return new ResponseEntity<>("Id is Invalid", HttpStatus.UNPROCESSABLE_ENTITY);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>("Failed in Updating", HttpStatus.BAD_REQUEST);
    }

}
