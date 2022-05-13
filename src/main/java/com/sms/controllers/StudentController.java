package com.sms.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sms.beans.Student;
import com.sms.dao.StudentDao;

@Controller
public class StudentController {
	
	@Autowired  
    StudentDao studentDao; 
     
    @GetMapping("/studentform")  
    public String showform(Model m){  
    	m.addAttribute("command", new Student());
    	return "studentform"; 
    } 
    
    @PostMapping(value="/save")  
    public String save(@ModelAttribute("Student") Student student, RedirectAttributes redirectAtt){
    	Student isExistingUser = studentDao.getStudentById(student.getStudentId());
    	if(isExistingUser != null) {
    		redirectAtt.addFlashAttribute("error", "Entered Student ID already exists in our Records. Please Enter a different Student ID");
    		redirectAtt.addFlashAttribute("student", student);
    		return "redirect:/studentform";
    	}else if(!(student.getEmail().contains("@")) || !(student.getEmail().toLowerCase().contains(".com"))) {
    		redirectAtt.addFlashAttribute("error", "Please Enter a valid Email ID");
    		redirectAtt.addFlashAttribute("student", student);
    		return "redirect:/studentform";
    	}else {
        studentDao.saveStudent(student); 
        return "redirect:/viewstudent";
    	}
    }  
       
    @GetMapping("/viewstudent")  
    public String viewemp(Model m){  
        List<Student> list=studentDao.getStudents();  
        m.addAttribute("list",list);
        return "viewstudent";  
    } 
    
    @GetMapping(value="/editstudent/{id}")  
    public String edit(@PathVariable int id, Model m){  
        Student student=studentDao.getStudentById(id);  
        m.addAttribute("command",student);
        return "studenteditform";  
    } 
    
    @PostMapping(value="/editsave")  
    public String editsave(@ModelAttribute("Student") Student student, RedirectAttributes redirectAtt){ 
    	if(!(student.getEmail().contains("@")) || !(student.getEmail().contains(".com"))) {
    		redirectAtt.addFlashAttribute("error", "Please Enter a valid Email ID");
    		String url = "/editstudent/"+student.getStudentId();
    		return "redirect:"+url;
    	}else {
    		studentDao.updateStudent(student); 
            return "redirect:/viewstudent";
    	}
    } 
    
    @GetMapping(value="/deletestudent/{id}")  
    public String delete(@PathVariable int id){  
        studentDao.deleteStudentById(id);
        return "redirect:/viewstudent";  
    } 

}
