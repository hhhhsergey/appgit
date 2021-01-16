package com.hhhh.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.hhhh.app.dao.LessonDAOimpl;
import com.hhhh.app.dao.UserDAOimpl;
import com.hhhh.app.entity.Lesson;
import com.hhhh.app.entity.User;

@Service
public class Services {
	Mathcontainer mc=new Mathcontainer();

	@Autowired
	private LessonDAOimpl lessonDAOimpl;
	
	//not use
	public Lesson findbyid_math(int id_math) {
		return lessonDAOimpl.findById(id_math);
	}
	
	//use
	//создать объект mathcontainer для формы testingform
	public Mathcontainer genereateMathcontainer() {
		Mathcontainer mathContainer=new Mathcontainer();
		
			//plus
				mathContainer.setTwo1((int)(Math.random()*(20-1)+1));
				mathContainer.setResult1((int)(Math.random()*(100-21)+21));
				mathContainer.setOne1(mathContainer.getResult1()-mathContainer.getTwo1());
			//minus
				mathContainer.setTwo2((int)(Math.random()*(20-1)+1));
				mathContainer.setResult2((int)(Math.random()*(100-21)+21));
				mathContainer.setOne2(mathContainer.getResult2()+mathContainer.getTwo2());
			//multiplication
				mathContainer.setOne3((int)(Math.random()*(20-1)+1));
				mathContainer.setTwo3((int)(Math.random()*(10-1)+1));
				mathContainer.setResult3(mathContainer.getOne3()*mathContainer.getTwo3());
			//division
				mathContainer.setTwo4((int)(Math.random()*(20-1)+1));
				mathContainer.setResult4((int)(Math.random()*(10-1)+1));
				mathContainer.setOne4(mathContainer.getTwo4()*mathContainer.getResult4());
		return mathContainer;
	}
	
	//use
	//перенести в объект с сессии результаты объекта с формы
	public void combinemathcontainers(Mathcontainer mathcontainerbefore,Mathcontainer mathcontainernew) {
		mathcontainerbefore.setUserresult1(mathcontainernew.getUserresult1());
		mathcontainerbefore.setUserresult2(mathcontainernew.getUserresult2());
		mathcontainerbefore.setUserresult3(mathcontainernew.getUserresult3());
		mathcontainerbefore.setUserresult4(mathcontainernew.getUserresult4());
	}
	
	//use
	//рассчитать урок
	public void createlesson(Mathcontainer mathcontainer) {
		double rank = 0;
		double rank_total;
		int id_user;
		//find username by spring security
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName();
		//считаем ранк(ранк урока)
		if(mathcontainer.getResult1()==mathcontainer.getUserresult1())rank++;
		if(mathcontainer.getResult2()==mathcontainer.getUserresult2())rank++;
		if(mathcontainer.getResult3()==mathcontainer.getUserresult3())rank++;
		if(mathcontainer.getResult4()==mathcontainer.getUserresult4())rank++;
		rank=rank/4;
		//находим тотал ранк
		id_user=userDAOimpl.getIdByUsername(name);
		Lesson lesson=lessonDAOimpl.getLastLessonById_user(id_user);
		int lessonNumber=lessonDAOimpl.getLessonNumberById_user(id_user);
		rank_total=(rank+lesson.getRank_total()*lessonNumber)/(lessonNumber+1);
		lessonDAOimpl.create(rank, rank_total, id_user);
	}
	
	//use
	//stast for menu
	public List<Lesson> getLastFiveLessons(String username) {
		int id_user=userDAOimpl.getIdByUsername(username);
		return lessonDAOimpl.getLastFiveLessonsById_user(id_user);
	} 

	//use
	//stast for menu
	public List<Lesson> getAllLessons(String username) {
		int id_user=userDAOimpl.getIdByUsername(username);
		return lessonDAOimpl.listAlllessonsByUsername(id_user);
	} 
	
	//not use
	//save lesson
	public void savelesson(double rank,double rank_total, int id_user) {
		lessonDAOimpl.create(rank,rank_total,id_user);
	}
	
	//use
	@Autowired
	UserDAOimpl userDAOimpl;
	//create user
	public void createuser(String username,String password) {
		userDAOimpl.create(username,password);
	}
	
	//use
	//проверка наличия пользователя в базе
	public boolean usernameExsist(String username) {
		if(userDAOimpl.usernameExist(username))return true;
		return false;
	}
	
	//notuse
	public User finduserbyusername(String username) {
		return userDAOimpl.findByUsername(username);
		
	}
}
