package com.jpahibernate.example.student_management_db.service;

import com.jpahibernate.example.student_management_db.model.Student;
import com.jpahibernate.example.student_management_db.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service

public class StudentService {

    @Autowired

    private StudentRepository studentRepository;

    public String addDetails(Student studentdata){
          studentRepository.save(studentdata);

        return "Student details saved successfully";

    }

    public Student getbyID(int id){
        Optional<Student> response = studentRepository.findById(id);

        if(response.isPresent()){
            return response.get();
        }
        return null;

    }
    
    public String updateById(int id, Student newRequest){

        Student existingStudent = getbyID(id);

        if(existingStudent != null){
            studentRepository.save(newRequest);
            return "update is successfull";
        }
        else{
            return "the requested id :"+id+"is not present";
        }
    }


    public String updateBySpecific(int id, String email){

        Student existingStudent = getbyID(id);

        if(existingStudent != null){

            existingStudent.setEmail(email);
            studentRepository.save(existingStudent);
            return "update is successfull";
        }
        else{
            return "the requested id :"+id+"is not present";
        }
    }
}
