package com.bvk.client;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ClientStudentBulkUpdate {
	public static void main(String[] args) {
		try{
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			String hql = "UPDATE Student SET percent = 100";
			
			Query query = session.createQuery(hql);
			
			int result = query.executeUpdate();
			tx.commit();
			System.out.println("Records updated: " + result);
			}catch(Exception e){
				System.out.println("Record couldn't be updated..." + e.getMessage());
			}
	}
}