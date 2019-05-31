package com.bvk.client;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ClientStudentUpdateConditional {
	public static void main(String[] args) {
		try{
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			String hql = "UPDATE Student SET percent = percent - 10 WHERE studentid = :studentId";
			
			Query query = session.createQuery(hql);
			query.setParameter("studentId", 4);
			
			int result = query.executeUpdate();
			tx.commit();
			System.out.println("Records updated: " + result);
			}catch(Exception e){
				System.out.println("Record couldn't be updated..." + e.getMessage());
			}
	}

}
