package com.app.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.dto.Login;
import com.app.entity.User;

@Repository
public class UserDaoImpl implements UserDao {
	@Autowired
	EntityManager eMan;

	@Override
	public User newUser(User user) {
		eMan.persist(user);
		User u = eMan.find(User.class, user.getId());
		return u;
	}

	@Override
	public User fetchUser(Login login) {
		Query qry = eMan
				.createQuery("Select user from User as user where user.email=:email and user.password=:password");
		qry.setParameter("email", login.getEmail());
		qry.setParameter("password", login.getPassword());
		if (qry.getResultList().size() > 0)
			return (User) (qry.getResultList().get(0));
		return null;
	}

	@Override
	public List<User> searchUser(String email) {

		Query qry = eMan.createQuery("Select user from User as user where user.email=?1");
		qry.setParameter(1, email);
		List<User> u = qry.getResultList();
		return u;
	}

}
