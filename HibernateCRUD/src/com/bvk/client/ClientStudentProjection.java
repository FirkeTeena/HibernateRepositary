package com.bvk.client;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Projections;

import com.bvk.entity.Student;

public class ClientStudentProjection {
	public static void main(String[] args) {
		try{
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			Session session = sessionFactory.openSession();
			
			Criteria criteriaStudent = session.createCriteria(Student.class);
			
			criteriaStudent.setProjection(Projections.rowCount());
			List<Integer> count = criteriaStudent.list();
			System.out.println("No. of records: "+count.get(0));
			
			criteriaStudent.setProjection(Projections.countDistinct("name"));
			System.out.println("Distinct names: "+criteriaStudent.list());
			
			
			criteriaStudent.setProjection(Projections.max("percent"));
			float max = (float)criteriaStudent.uniqueResult();
			System.out.println("Max percentage is: " + max);
			
			criteriaStudent.setProjection(Projections.min("percent"));
			float min = (float)criteriaStudent.uniqueResult();
			System.out.println("Min percentage is: " + min);
			
			}catch(Exception e){
				System.out.println("Record couldn't be updated..." + e.getMessage());
			}
	}
}