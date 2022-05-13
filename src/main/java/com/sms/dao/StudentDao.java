package com.sms.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sms.beans.Student;

@Service
public class StudentDao {
	

	@Autowired
	StudentRepository studentRepository;
	
	
    public Student saveStudent(Student student) {
       return studentRepository.save(student);
    }

    
    public List<Student> getStudents() {
       return studentRepository.findAll();
    }

  
    public Student getStudentById(int id) {
       Optional<Student> opt = studentRepository.findById(id);
       if(opt.isPresent()) {
           return opt.get();
       } else {
           return null;
       }
    }

    
    public void deleteStudentById(int id) {
    	studentRepository.delete(getStudentById(id));
    }

    
    public void updateStudent(Student Student) {
    	studentRepository.save(Student);
    }
}
