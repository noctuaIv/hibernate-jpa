package com.infiniteskills.data;

import java.util.Date;

import org.hibernate.Session;

import com.infiniteskills.data.entities.User;

public class Application {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.getTransaction().begin();

			User user = new User();
			user.setBirthDate(new Date());
			user.setCreatedBy("kevin");
			user.setCreatedDate(new Date());
			user.setEmailAddress("kmb385@yahoo.com");
			user.setFirstName("Kevin");
			user.setLastName("Bowersox");
			user.setLastUpdatedBy("kevin");
			user.setLastUpdatedDate(new Date());

			session.save(user);
			session.getTransaction().commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();			
		}
	}
}
