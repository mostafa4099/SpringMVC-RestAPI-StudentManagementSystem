package com.mostafa.sna.dao;

import java.util.List;

import com.mostafa.sna.entity.Student;

public interface StudentDAO {
	
	public List<Student> getAllStudents();

	public void saveOrUpdateStudent(Student student);

	public Student getStudent(int id);

	public void deleteStudent(int id);

	public List<Student> searchStudents(String searchName);
	
}
