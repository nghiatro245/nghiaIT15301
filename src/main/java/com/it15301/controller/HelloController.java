package com.it15301.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.it15301.entity.User;

@RestController
public class HelloController {
	
//	@ResponseBody
	@RequestMapping("/hello")
//	@ModelAttribute
	public String hello(Model model) {
		User user = new User();
		user.setName("Huong ny1");
		
		String message="huong ny";
		model.addAttribute("user", user);
		return "hello";
	}
	
//	@ResponseBody
	@GetMapping("/test")
	public String test() {
//		return "hello ong vang hny";
		return "redirect:/hello";
	}
	
	@ResponseBody
	@GetMapping("/demo-api")
	public String demoApi() {
		return "hny ko hoc lai";
	}
}
