package com.bvk.client;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.bvk.entity.Student;

public class ClientStudentCriteria {
	public static void main(String[] args) {
		try{
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			Session session = sessionFactory.openSession();
			
			Criteria criteriaStudent = session.createCriteria(Student.class);
			//criteriaStudent.add(Restrictions.eq("percent", 90.00f));
			criteriaStudent.add(Restrictions.gt("percent", 96.00f));
			List<Student>studentList = criteriaStudent.list();
			
			for (Student student : studentList) {
				System.out.println(student);
			}
			}catch(Exception e){
				System.out.println("Record couldn't be updated..." + e.getMessage());
			}
	}
}