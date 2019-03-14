package com.voytovych.data;

import java.util.Date;

import org.hibernate.Session;

import com.voytovych.data.entities.User;


public class Application {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
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
		session.close();
	}
}
