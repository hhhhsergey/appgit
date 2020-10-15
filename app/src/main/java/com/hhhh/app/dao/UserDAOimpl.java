package com.hhhh.app.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;

import org.springframework.stereotype.Repository;

@Repository
public class UserDAOimpl implements UserDAO{

	@PersistenceContext
	EntityManager em;
	
	
	@Override
	public void findById() {
		
	}

	@Override
	public void listAll() {
		
	}

	@Override
	public void save() {
		
	}

	@Override
	public void create() {
		
	}

}
