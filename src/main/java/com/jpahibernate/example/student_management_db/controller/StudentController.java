package com.jpahibernate.example.student_management_db.controller;


import com.jpahibernate.example.student_management_db.model.Student;
import com.jpahibernate.example.student_management_db.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController

@RequestMapping("/Student/api")
public class StudentController {

    @Autowired

    public StudentService studentService;

    @PostMapping("/save")
    public String saveStudent(@RequestBody Student studentdata){

        String response = studentService.addDetails(studentdata);

        return response;
    }

    @GetMapping("/name/{id}")

    public Student getid(@PathVariable int id){

        Student student = studentService.getbyID(id);

        return student;

    }

    @PutMapping("/update/{id}")

    public String updateById(@PathVariable int id, @RequestBody Student newRequest){
        String response = studentService.updateById(id,newRequest);
        return response;
    }

    @PatchMapping("/specific/{id}")

    public String updateBySpecific(@PathVariable int id, @RequestParam String email ){
        String response = studentService.updateBySpecific(id,email);
        return response;
    }

}
