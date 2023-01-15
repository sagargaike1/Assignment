package com.sagar.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sagar.model.Student;
import com.sagar.service.StudentService;

@RestController
public class StudentController {
	
	@Autowired
	StudentService studentservice;
	
	@PostMapping("/student")
	public String addStudent(@RequestBody Student student) {
		
		String result = studentservice.addStudent(student);
		return result;
	}

	@GetMapping("/students")
	public List <Student> getAllstudent(){
		return studentservice.getAllstudent();
		
	}
	

	@GetMapping("/student/{roll-no}")
	public Student getStudent(@PathVariable("id")Long id) {
		return studentservice.getStudent(id);
	}
	

	@DeleteMapping("/student/{roll-no}")
	public String deleteStudent(@PathVariable("id")Long id) {
		return studentservice.deleteStudent(id);
	}
}
