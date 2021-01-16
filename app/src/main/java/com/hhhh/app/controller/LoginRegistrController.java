package com.hhhh.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.hhhh.app.entity.User;
import com.hhhh.app.service.Services;

@Controller
public class LoginRegistrController {

	
	@Autowired
	Services services;
	
	@GetMapping("/registration")
	public String registration(@ModelAttribute("user") User user) {
		return "registration";
	}

	@PostMapping("/registration")
	public String createuser(@ModelAttribute("user") @Valid User user,BindingResult bindingResult,Model model) {
		if(bindingResult.hasErrors()) {
			return"registration";
		}
		if(services.usernameExsist(user.getUsername())) {
			model.addAttribute("messageUserExist","Пользователь уже существует");
			return"registration";
		}
		services.createuser(user.getUsername(),user.getPassword());
		model.addAttribute("messageUserCreated","пользователь зарегистрирован");
		return "registration";
		}
}
