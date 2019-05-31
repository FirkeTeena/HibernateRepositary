package com.bvk.client;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.bvk.entity.Student;

public class ClientStudentProgrammatic {
	public static void main(String[] args) {
		SessionFactory sessionFactory;
		Session session;
		
		Configuration config = new Configuration();
		
		config.addResource("student.hbm.xml");
		config.setProperty("hibernate.connection.driver_class", "oracle.jdbc.driver.OracleDriver");
		config.setProperty("hibernate.connection.url", "jdbc:oracle:thin:@localhost:1521:XE");
		config.setProperty("hibernate.connection.username", "bvk");
		config.setProperty("hibernate.connection.password", "bvk");
		config.setProperty("hibernate.dialect", "org.hibernate.dialect.Oracle9iDialect");
		
		sessionFactory = config.buildSessionFactory();
		
		try{
			session = sessionFactory.openSession();
			
			Transaction tx = session.beginTransaction();
			
			Student student = new Student();
			
			student.setStudentId(2);
			student.setName("svk");
			
			session.save(student);
			
			tx.commit();
			
			System.out.println("Record inserted...");
			}catch(Exception e){
				System.out.println("Record couldn't be inserted..." + e.getMessage());
			}
	}
}