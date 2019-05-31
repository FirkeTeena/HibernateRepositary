package com.bvk.client;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import com.bvk.entity.Student1;

public class ClientStudentInsertAnnotation {
	public static void main(String[] args) {
		try{
			SessionFactory sessionFactory = new AnnotationConfiguration().configure().
					addAnnotatedClass(com.bvk.entity.Student1.class).buildSessionFactory();
			Session session = sessionFactory.openSession();
			
			Transaction tx = session.beginTransaction();
			
			Student1 student1 = new Student1();
			
			student1.setStudentId(12);
			student1.setName("abc");
			
			session.save(student1);
			
			tx.commit();
			
			System.out.println("Record inserted...");
			}catch(Exception e){
				System.out.println("Record couldn't be inserted..." + e.getMessage());
				e.printStackTrace();
			}
	}
}