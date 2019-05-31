package com.bvk.client;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.bvk.entity.Student;

public class ClientStudentRead {
	public static void main(String[] args) {
		try{
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			Session session = sessionFactory.openSession();
			
			Transaction tx = session.beginTransaction();
			
			Student student = (Student)session.get(Student.class,new Integer(2));
			
			System.out.println(student);
			
			tx.commit();
			}catch(Exception e){
				System.out.println("Record couldn't be inserted..." + e.getMessage());
			}
	}
}