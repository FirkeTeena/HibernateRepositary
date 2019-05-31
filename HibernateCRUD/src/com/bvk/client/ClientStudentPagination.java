package com.bvk.client;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.bvk.entity.Student;

public class ClientStudentPagination {
	public static void main(String[] args) {
		try{
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			Session session = sessionFactory.openSession();
			
			Query query = session.createQuery("FROM Student");
			query.setMaxResults(3);
			List<Student>students = (List<Student>)query.list();
			
			Iterator<Student>stuIterator = students.iterator();
			
			while(stuIterator.hasNext()){
				Student student = stuIterator.next();
				System.out.println("Student ID: " + student.getStudentId());
				System.out.println("Student Name: " + student.getName());
				System.out.println("==================================================");
			}
			
			System.out.println("New result:");
			
			students = (List<Student>)query.list();
			
			stuIterator = students.iterator();
			
			while(stuIterator.hasNext()){
				Student student = stuIterator.next();
				System.out.println("Student ID: " + student.getStudentId());
				System.out.println("Student Name: " + student.getName());
				System.out.println("==================================================");
			}
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
}