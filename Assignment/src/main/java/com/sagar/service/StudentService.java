package com.sagar.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sagar.Dao.StudentRepository;
import com.sagar.model.Student;

@Service
public class StudentService {

	@Autowired
	StudentRepository studentrepo;

	public String addStudent(Student student) {

		Student std = studentrepo.save(student);

		return "Student " + std.getUsername()+ " has been added....!!";
	}

	public List<Student> getAllstudent() {
		List<Student> stds = (List<Student>) studentrepo.findAll();

		return stds;
	}

	public String deleteStudent(Long id) {
		 studentrepo.deleteById(id);
		return "Student is deleted";
	}

	public Student getStudent(Long id) {
		Optional<Student> std = studentrepo.findById(id);
		return std.isPresent() ? std.get() : new Student();

	}

}
