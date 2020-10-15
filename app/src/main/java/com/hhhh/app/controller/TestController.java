package com.hhhh.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hhhh.app.entity.Lesson;
import com.hhhh.app.service.Services;

@RestController
public class TestController {
	
	@Autowired
	private Services services;
	
	@GetMapping("/main/{id_math}")
	@ResponseBody
	public Lesson findbyid_math(@PathVariable int id_math,Model model) {
		Lesson lesson=services.findbyid_math(id_math);
		return lesson;
		
	}
	@GetMapping("/main/list")
	@ResponseBody
	public List<Lesson> listall() {
		List<Lesson> listall=services.listall();
		return listall;
		
	}
	

}
