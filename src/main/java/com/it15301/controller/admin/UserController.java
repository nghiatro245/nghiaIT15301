package com.it15301.controller.admin;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.SpringVersion;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.it15301.dto.UserDTO;
import com.it15301.entity.User;
import com.it15301.mappers.UserMapper;
import com.it15301.repositories.UserRepository;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

@Controller
@RequestMapping(value="/admin/users")
public class UserController {
	@Autowired
	private HttpServletRequest request;
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private UserMapper mapper;
	
	@GetMapping
	public String index(Model model) {
		
		List<User> listUser = this.userRepo.findAll();
		
		model.addAttribute("listUser", listUser);
		
		return "admin/users/index";
	}
	
	@GetMapping(value="{id}")
	public String show(Model model,
			@PathVariable(name="id") User entity) {
//		User entity = this.userRepo.getReferenceById(id);
		
		UserDTO dto = this.mapper.convertToDTO(entity);
		
		model.addAttribute("user", dto);
		return "admin/users/show";
	}
	
	@GetMapping(value="/create")
	public String create() {
		return "admin/users/create";
	}
	
	@PostMapping(value="/store")
	public String store(Model model,
						@Valid UserDTO dto,
						BindingResult result) {
		if(result.hasErrors()) {
			System.out.println("Có lỗi");
			model.addAttribute("errors", result.getAllErrors());
			return "admin/users/create";
		}else {
			
			User entity = this.mapper.convertToEntity(dto);
			this.userRepo.save(entity);
			return "redirect:/admin/users";
		}
	}
	
	@GetMapping(value="/edit/{id}")
	public String edit(Model model,
						@PathVariable("id") User entity) {
		UserDTO dto = this.mapper.convertToDTO(entity);
//		UserDTO user = new UserDTO();
		
		model.addAttribute("user", dto);
//		model.addAttribute(user);
		
		return "admin/users/edit";
	}
	
	@PostMapping(value="/update/{id}")
	public String update(Model model,
			@Valid UserDTO user,
			BindingResult result) {
		
		if(result.hasErrors()) {
			System.out.println("Có lỗi");
//			return "redirect:/admin/users/edit/1";
			model.addAttribute("errors", result.getAllErrors());
			return "admin/users/edit";
		}else {
			System.out.println("Không có lỗi");
			User entity = this.mapper.convertToEntity(user);
			this.userRepo.save(entity);
			return "redirect:/admin/users";
		}
	}
	
	@PostMapping(value="/delete/{id}")
	public String delete(@PathVariable("id") Integer id) {
		this.userRepo.deleteById(id);
		return "redirect:/admin/users";
	}
}
