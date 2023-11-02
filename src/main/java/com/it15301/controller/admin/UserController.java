package com.it15301.controller.admin;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.SpringVersion;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.it15301.dto.User;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

@Controller
@RequestMapping(value="/admin/users")
public class UserController {
	@Autowired
	private HttpServletRequest request;
	@GetMapping
	public String index() {
		return "admin/users/index";
	}
	
	@GetMapping(value="{id}")
	public String show(
			Model model,
			@PathVariable(name="id") Integer id) {
		
//		this.request.getParameter("id");
		System.out.println("id: "+id);
		
		model.addAttribute("id", id);
		return "admin/users/show";
	}
	
	@GetMapping(value="/create")
	public String create() {
		return "admin/users/create";
	}
	
	@PostMapping(value="/store")
	public String store() {
		return "redirect:/admin/users";
	}
	
	@GetMapping(value="/edit/{id}")
	public String edit(Model model) {
		
		User user = new User();
		
		user.setId(1);
		user.setName("Tran huong ly");
		user.setStudentCode("hny123");
		user.setEmail("hny123@gmail");
		user.setPassword("123");
		user.setDob(new Date(2002,01,01));
		user.setAvatar("");
		user.setRole(1);
		user.setGender(2);
		user.setStatus(1);
		
		model.addAttribute("user", user);
//		model.addAttribute(user);
		
//		System.out.println("version: "+ SpringVersion.getVersion());
		
		return "admin/users/edit";
	}
	
	@PostMapping(value="/update/{id}")
	public String update(Model model,
			@Valid User user,
			BindingResult result) {
		
		if(result.hasErrors()) {
			System.out.println("Có lỗi");
//			return "redirect:/admin/users/edit/1";
			model.addAttribute("errors", result.getAllErrors());
			return "admin/users/edit";
		}else {
			System.out.println("Không có lỗi");
			return "redirect:/admin/users";
		}
		
	}
	
	@PostMapping(value="/delete/{id}")
	public String delete() {
		return "redirect:/admin/users";
	}
	
	
}
