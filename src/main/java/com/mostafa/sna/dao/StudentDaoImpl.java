package com.mostafa.sna.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.mostafa.sna.entity.Student;

@Repository
public class StudentDaoImpl implements StudentDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Student> getAllStudents() {
		Session session = sessionFactory.getCurrentSession();

		Query<Student> query = session.createQuery("from Student order by lastName", Student.class);

		List<Student> list = query.getResultList();

		return list;
	}

	@Override
	public void saveOrUpdateStudent(Student student) {

		Session session = sessionFactory.getCurrentSession();

		session.saveOrUpdate(student);

	}

	@Override
	public Student getStudent(int id) {

		Session session = sessionFactory.getCurrentSession();

		Student student = session.get(Student.class, id);

		return student;
	}

	@Override
	public void deleteStudent(int id) {

		Session session = sessionFactory.getCurrentSession();

		Student student = session.get(Student.class, id);

		session.delete(student);

//		Query query = session.createQuery("delete from Student where id=: studentId");
//		query.setParameter("studentId", id);
//		query.executeUpdate();

	}

	@Override
	public List<Student> searchStudents(String searchName) {

		Session session = sessionFactory.getCurrentSession();

		Query<Student> query = null;

		if (searchName != null && searchName.trim().length() > 0) {
			
			query = session.createQuery(
					"from Student where lower(firstName) like :theName or lower(lastName) like :theName",
					Student.class);
			query.setParameter("theName", "%" + searchName.toLowerCase() + "%");

		} else {
			query = session.createQuery("from Student", Student.class);
		}
		
		List<Student> student = query.getResultList();

		return student;
	}

}
