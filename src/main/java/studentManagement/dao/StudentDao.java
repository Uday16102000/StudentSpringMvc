package studentManagement.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import antlr.collections.List;
import studentManagement.dto.Student;

@Repository
public class StudentDao {
	@Autowired
    private EntityManager  entityManager;
	public Student saveStudent(Student student)
	{
		EntityTransaction entityTransaction= entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(student);
		entityTransaction.commit();
		
		return student;
		
	}
	public java.util.List<Student> getAllStudent()
	{EntityTransaction entityTransaction=entityManager.getTransaction();
	javax.persistence.Query query=entityManager.createQuery("select s from Student s");
	java.util.List<Student> list= query.getResultList();
		return list;
		
	}
	public void deleteById(int id) {
	EntityTransaction transaction  = entityManager.getTransaction();
	Student student= entityManager.find(Student.class, id);
	transaction.begin();
	entityManager.remove(student);
	transaction.commit();
	
		// TODO Auto-generated method stub
		
	}
	public Student findStudentById(int id) {
		// TODO Auto-generated method stub
		Student student=entityManager.find(Student.class,id);
		return student;
	}
	public void updateStudent(Student student) {
		EntityTransaction transaction  = entityManager.getTransaction();
	transaction.begin();
	entityManager.merge(student);
	transaction.commit();
	
	
	}
}
