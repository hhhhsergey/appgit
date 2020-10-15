package com.hhhh.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hhhh.app.dao.LessonDAOimpl;
import com.hhhh.app.dao.UserDAO;
import com.hhhh.app.entity.Lesson;

@Service
public class Services {

	@Autowired
	private LessonDAOimpl lessonDAOimpl;
	
	public Lesson findbyid_math(int id_math) {
		return lessonDAOimpl.findById(id_math);
	}
	public List<Lesson> listall() {
		return lessonDAOimpl.listAll();
	}

}
