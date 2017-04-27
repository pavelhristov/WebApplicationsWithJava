package com.weatherforecast.services;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;

import com.weatherforecast.db.HibernateUtils;
import com.weatherforecast.models.User;
import com.weatherforecast.services.contracts.IUserService;

@Service
public class UserService implements IUserService {

	@Override
	public void saveUserSearchData(String userIP, String browse) {
		Session session = HibernateUtils.getSessionFactory().openSession();

		Transaction transaction = session.getTransaction();
		transaction.begin();

		User user = new User();
		user.setUserIP(userIP);
		user.setBrowse(browse);
		user.setDate(new Date());

		session.save(user);
		transaction.commit();

		session.close();
	}
}
