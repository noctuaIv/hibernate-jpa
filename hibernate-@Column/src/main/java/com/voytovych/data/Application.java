package com.voytovych.data;

import java.util.Date;

import org.hibernate.Session;

import com.voytovych.data.entities.User;

public class Application {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.getTransaction().begin();

			User user = new User();
			user.setBirthDate(null);
			user.setCreatedBy("kevin");
			user.setCreatedDate(new Date());
			user.setEmailAddress("kmb385@yahoo.com");
			user.setFirstName("Kevin");
			user.setLastName("Bowersox");
			user.setLastUpdatedBy("kevin");
			user.setLastUpdatedDate(new Date());

			session.save(user);
			session.getTransaction().commit();
	
			session.beginTransaction();
		    User dbUser = (User) session.get(User.class, user.getUserId());
		    dbUser.setFirstName("Joe");
		    session.update(dbUser);
			session.getTransaction().commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			session.close();
		}
	}
}
