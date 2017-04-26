package com.weatherforecast;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.weatherforecast.db.HibernateUtils;
import com.weatherforecast.models.User;

@SpringBootApplication
public class WeatherforecastApplication {

	public static void main(String[] args) {
		SpringApplication.run(WeatherforecastApplication.class, args);

		Session session = HibernateUtils.getSessionFactory().openSession();
		
		Criteria criteria = session.createCriteria(User.class);
		
		List<User> users = criteria.list();
		
		session.close();
		
		System.out.print(users.size());
	}
}
