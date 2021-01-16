package com.hhhh.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hhhh.app.dao.LessonDAOimpl;
import com.hhhh.app.dao.UserDAOimpl;
import com.hhhh.app.entity.Lesson;
import com.hhhh.app.service.Services;

@RestController
public class TestController {
	
	@Autowired
	private Services services;
	@Autowired
	private UserDAOimpl userDAOimpl;
	@Autowired
	private LessonDAOimpl lessonDAOimpl;
	
	
//	@GetMapping("/main/{id_math}")
//	@ResponseBody
//	public Lesson findbyid_math(@PathVariable int id_math,Model model) {
//		Lesson lesson=services.findbyid_math(id_math);
//		return lesson;
//	}
	
//	@GetMapping("/main/list")
//	public ModelAndView showlist(Model model) {
//		List<Lesson> listallranks=services.listall();
//		ModelAndView mv=new ModelAndView("lessonlist");
//		mv.addObject("listallrank",listallranks);
//		return mv;
//		
//	}
	
	@GetMapping("/1")
	@ResponseBody
	public Lesson getLesson() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName();
		int id_user=userDAOimpl.getIdByUsername(name);
		Lesson lesson=lessonDAOimpl.getLastLessonById_user(id_user);
		return lesson;
	}

}
