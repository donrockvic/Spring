package com.rest.app.rest;

import com.rest.app.entity.Student;
import com.rest.app.errors.StudentNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    List<Student> students = new ArrayList<>();


    private void fetchStudent(){
        students.add(new Student(1,"vicky", "kumar"));
        students.add(new Student(2,"gandu", "cl"));
        students.add(new Student(3, "kala", "nag"));
    }

    @GetMapping("/students")
    public List<Student> getStudent(){
        fetchStudent();
        return students;
    }

    @GetMapping("/student/{studentId}")
    public Student getStudent(@PathVariable int studentId){
        fetchStudent();
        if(studentId>=students.size() || studentId<0 ){
            throw new StudentNotFoundException("student with the id: "+studentId+" not found");
        }
        return students.get(studentId);
    }


}
