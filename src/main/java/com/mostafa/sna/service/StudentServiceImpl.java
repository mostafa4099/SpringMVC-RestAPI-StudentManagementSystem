package com.mostafa.sna.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mostafa.sna.dao.StudentDAO;
import com.mostafa.sna.entity.Student;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentDAO studentDAO;

	@Override
	@Transactional
	public List<Student> getAllStudents() {
		return studentDAO.getAllStudents();
	}

	@Override
	@Transactional
	public void saveOrUpdateStudent(Student student) {
		
		studentDAO.saveOrUpdateStudent(student);
		
	}

	@Override
	@Transactional
	public Student getStudent(int id) {
		return studentDAO.getStudent(id);
	}

	@Override
	@Transactional
	public void deleteStudent(int id) {
		
		studentDAO.deleteStudent(id);
		
	}

	@Override
	@Transactional
	public List<Student> searchStudents(String searchName) {
		return studentDAO.searchStudents(searchName);
	}

}
