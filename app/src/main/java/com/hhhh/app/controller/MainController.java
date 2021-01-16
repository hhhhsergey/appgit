package com.hhhh.app.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.hhhh.app.entity.Lesson;
import com.hhhh.app.service.Mathcontainer;
import com.hhhh.app.service.Services;

@Controller
public class MainController {

	@Autowired
	private Services services;
		
	@GetMapping("/menu")
	public ModelAndView hello(HttpSession session) {
		//nobody did'nt see this
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = auth.getName();
		session.setAttribute("username", username);
		ModelAndView modelAndView =new ModelAndView("menu");
		List<Lesson>fivelessons=services.getLastFiveLessons(username);
		modelAndView.addObject("fivelessons",fivelessons);
		modelAndView.addObject("name",username);
		return modelAndView;
	}
	
	@GetMapping("/menu/alllessons")
	public ModelAndView showalllessons(HttpSession session) {
		String username=(String) session.getAttribute("username");
		ModelAndView modelAndView =new ModelAndView("allLessons");
		List<Lesson>allLessons=services.getAllLessons(username);
		modelAndView.addObject("allLessons",allLessons);
		return modelAndView;
	}
	
	@GetMapping("/menu/testingform")
	public ModelAndView testout(HttpSession session) {
		ModelAndView modelAndView =new ModelAndView("testingform");
		Mathcontainer mathcontainer=services.genereateMathcontainer();
		session.setAttribute("mathcontainer", mathcontainer);
		mathcontainer.toString();
		modelAndView.addObject("mathcontainer", mathcontainer);
		return modelAndView;
	}
	
	@PostMapping("/menu/testingform")
	public ModelAndView test(@ModelAttribute("mathcontainer") Mathcontainer mathcontainernew, HttpSession session) {
		Mathcontainer mathcontainerbefore=(Mathcontainer)session.getAttribute("mathcontainer");
		services.combinemathcontainers(mathcontainerbefore, mathcontainernew);
		services.createlesson(mathcontainerbefore);//расчет и сохранение
		String username=(String)session.getAttribute("username");
		List<Lesson>fivelessons=services.getLastFiveLessons(username);
		ModelAndView modelAndView =new ModelAndView("menu");
		modelAndView.addObject("fivelessons",fivelessons);
		modelAndView.addObject("name",username);
		return modelAndView;
	}
	
}
