package com.mostafa.sna.service;

import java.util.List;

import com.mostafa.sna.entity.Student;

public interface StudentService {
	
	public List<Student> getAllStudents();

	public void saveOrUpdateStudent(Student student);

	public Student getStudent(int id);

	public void deleteStudent(int id);

	public List<Student> searchStudents(String searchName);
	
}
