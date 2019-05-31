package com.bvk.client;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ClientStudentSelectDistinct {
	public static void main(String[] args) {
		try{
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			Session session = sessionFactory.openSession();
			List<String>students = (List<String>)session.createQuery("SELECT DISTINCT(s.name) FROM Student s").list();
			
			Iterator<String>stuIterator = students.iterator();
			
			while(stuIterator.hasNext()){
				String name = stuIterator.next();
				System.out.println("Student Name: " + name);
				System.out.println("==================================================");
			}
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
}