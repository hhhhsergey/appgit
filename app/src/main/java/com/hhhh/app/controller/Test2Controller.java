package com.hhhh.app.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.hhhh.app.entity.Lesson;
import com.hhhh.app.service.Mathcontainer;
import com.hhhh.app.service.Services;

@Controller
//@SessionAttributes(types=Mathcontainer.class)
//@SessionAttributes("mc")
public class Test2Controller {
	
	
	
	
	@Autowired
	private Services services;
	
	
	//test save lesson
	@GetMapping("/main/save")
	public ModelAndView testsave() {
		double a=2;
		double b=22;
		int c=1;//id_user
		services.savelesson(a, b,c);
		String message = "test save lesson";
		ModelAndView mv=new ModelAndView("mainpage");
		mv.addObject("message", message);
		return mv;
	}
	
	//<a href="/main">main page?</a>
	
//	@ModelAttribute("mc")
//	public Mathcontainer getMC() {
//		return mc();
//	}
	
	//try send 
	@GetMapping("/test")
	public String test(Model model, HttpSession session) {
		String message = "test is here";
		model.addAttribute("message", message);
//		Mathcontainer mc=services.generateMC();
//		закоментил, т.к. переписал метод
//		model.addAttribute("mc", mc);
		System.out.println("check 1 step");
//		session.setAttribute("mc", mc);
		return "testlist";
	}
	//try get back
	@PostMapping("/test")
	public String result(@RequestParam("userresult") double userresult, HttpSession session, Mathcontainer mc, Model model) {
		mc=(Mathcontainer)session.getAttribute("mc");
		String message = "test with result is here";
//		services.setuserresult(mc, userresult);
		model.addAttribute("message", message);
		model.addAttribute("mc",mc);
		System.out.println("step2 "+mc.toString());
		return "testresult";
	}

}
