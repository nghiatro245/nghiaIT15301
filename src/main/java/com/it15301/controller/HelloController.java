package com.it15301.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.it15301.entity.User;
import com.it15301.utilities.UploadFileUtils;

import jakarta.servlet.ServletContext;

@Controller
public class HelloController {
	@Autowired
	private ServletContext app;
	
	@Autowired
	private UploadFileUtils uploadUtil;
	
//	@ResponseBody
	@RequestMapping("/hello")
//	@ModelAttribute
	public String hello(Model model) {
		User user = new User();
		user.setUsername("Huong ny1");
		
		String message="huong ny";
		model.addAttribute("user", user);
		System.out.println(this.app.getRealPath(""));
		return "hello";
	}
	
	@PostMapping("/upload-hello")
	public String uploadFileHello(@RequestParam("upload_file") MultipartFile uploadedFile) {
		this.uploadUtil.handleUploadFile(uploadedFile);
		
//		System.out.println(this.app.getRealPath(""));
		return "redirect:/hello";
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
