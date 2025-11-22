package com.luv2code.demo.rest;

import com.luv2code.demo.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {



    @GetMapping("/students")
    public List<Student> getStudents() {

        List<Student> theStudents = new ArrayList<Student>();

        theStudents.add(new Student("Alex", "Ceretta"));
        theStudents.add(new Student("André", "Ceretta"));
        theStudents.add(new Student("Caio", "Ceretta"));


        return theStudents;
    }

}
