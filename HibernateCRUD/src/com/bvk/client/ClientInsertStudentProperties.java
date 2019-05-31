package com.bvk.client;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.bvk.entity.Student;

public class ClientInsertStudentProperties {

	public static void main(String[] args) {
		try{
			SessionFactory sessionFactory = new Configuration().configure("hibernate.properties").buildSessionFactory();
			Session session = sessionFactory.openSession();
			
			Transaction tx = session.beginTransaction();
			
			Student student = new Student();
			
			student.setStudentId(4);
			student.setName("svk");
			
			session.save(student);
			
			tx.commit();
			
			System.out.println("Record inserted...");
			}catch(Exception e){
				System.out.println("Record couldn't be inserted..." + e.getMessage());
				e.printStackTrace();
			}
	}
}