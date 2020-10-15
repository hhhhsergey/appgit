package com.hhhh.app.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//для начала используем простую таблицу
@Entity
public class User {
	
	private long id;
	private String username;
	private String pass;

	public User() {
		
	};
	
	public User(long id,String username,String pass) {
		this.id=id;
		this.username=username;
		this.pass=pass;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	
}
