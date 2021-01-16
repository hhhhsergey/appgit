package com.hhhh.app.dao;

import javax.jws.soap.SOAPBinding.Use;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hhhh.app.entity.Lesson;
import com.hhhh.app.entity.User;

@Repository
@Transactional
public class UserDAOimpl implements UserDAO {

	@PersistenceContext
	EntityManager entityManager;

	//not use
	public void findById() {
	}

	//not use
	public User findByUsername(String username) {
		Query query = entityManager.createQuery("SELECT u FROM  user_table WHERE  u.username=:username");
		User user = (User) query.getSingleResult();
		return user;
	}
	
	//use
	//return true if username exist
	public boolean usernameExist(String username) {
		//no exception "no entity" with count
		long a= entityManager.createQuery("SELECT COUNT(*) FROM User u WHERE u.username=:name",Long.class).setParameter("name", username).getSingleResult();
		int b=(int)a;
		System.out.println("user from db if exist "+b);
		if(a==1)return true;
		return false;
	}

	//not use
	public void listAll() {

	}

	//use
	// create
	@Override
	@Transactional
	public void create(String username, String password) {
		User user = new User(username, password);
		user.setUserrole("User");
		user.setActive(true);
		System.out.println(user.toString());
		entityManager.persist(user);
	}

	//not use
	@Override
	public void save() {

	}

	//not use
	public int getIdByUsername(String username) {
		User user = entityManager.createQuery("SELECT e FROM  User e WHERE  e.username=:username",User.class).setParameter("username", username).getSingleResult();
		return (int)user.getId();
	}
	

}
