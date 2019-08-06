package com.mostafa.sna.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mostafa.sna.entity.Student;
import com.mostafa.sna.service.StudentService;

@RestController
@RequestMapping("/api")
public class StudentRestController {
	
	@Autowired
	private StudentService service;
	
	@GetMapping("/students")
	public List<Student> getAllStudents(){
		return service.getAllStudents();
	}
	
	@GetMapping("/students/{studentId}")
	public Student getStudent(@PathVariable int studentId){
		
		Student student = service.getStudent(studentId);
		if(student==null) {
			throw new StudentNotFoundException("Student Not Found For Student Id : "+studentId);
		}
		
		return student;
		
	}
	
	@PostMapping("/students")
	public Student addStudent(@RequestBody Student student) {
		
//		to notify hibernate this is should be save
		student.setId(0);
		
		service.saveOrUpdateStudent(student);
		
		return student;
		
	}
	
	@PutMapping("/students")
	public Student updateStudent(@RequestBody Student student) {
		
		service.saveOrUpdateStudent(student);
		
		return student;
		
	}
	
	@DeleteMapping("/students/{studentId}")
	public String deleteStudent(@PathVariable int studentId){
		
		Student student = service.getStudent(studentId);
		
		if(student==null) {
			throw new StudentNotFoundException("Student Not Found For Student Id : "+studentId);
		}
		
		service.deleteStudent(studentId);
		
		return "Student Deleted for student id "+studentId;
		
	}
	
}
