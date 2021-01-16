package com.hhhh.app.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

//для начала используем простую таблицу
@Entity
@Table(name = "user_table", schema = "mathapp")
public class User implements Serializable{
	
	/**
	 * по требованию Serializable
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Size(min=6,max=30,message="Значение должно быть от 6 до 30 символов")
	private String username;
	@Size(min=6,max=30,message="Значение должно быть от 6 до 30 символов")
	private String password;
	private boolean active;
	private String userrole;

	public User() {
	};
	
	public User(String username,String password) {
		this.username=username;
		this.password=password;
	}
	//TODO используемый код?
	public User(int id,String username,String password,boolean active, String userrole) {
		this.id=id;
		this.username=username;
		this.password=password;
		this.active=active;
		this.userrole=userrole;
	}
	
	public long getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public String getUserrole() {
		return userrole;
	}
	public void setUserrole(String userrole) {
		this.userrole = userrole;
	}
	
	
	@Override
	public String toString() {
		return "user toString "
				+ "[id "+getId()
				+"][username "+getUsername()
				+"][password "+getPassword()
				+"][active "+isActive()
				+"][userrole "+getUserrole()
				+"]";
		
	}
	
}
