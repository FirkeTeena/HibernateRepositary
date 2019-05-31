package com.bvk.client;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.bvk.entity.Student;

public class ClientStudentSelect {
	public static void main(String[] args) {
		try{
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			Session session = sessionFactory.openSession();
			List<Student>students = (List<Student>)session.createQuery("FROM Student").list();
			
			Iterator<Student>stuIterator = students.iterator();
			
			while(stuIterator.hasNext()){
				Student student = stuIterator.next();
				System.out.println("ID: " + student.getStudentId());
				System.out.println("Name: " + student.getName());
				System.out.println("Percent: " + student.getPercent());
				System.out.println("==================================================");
			}
			System.out.println("Done.");
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
}