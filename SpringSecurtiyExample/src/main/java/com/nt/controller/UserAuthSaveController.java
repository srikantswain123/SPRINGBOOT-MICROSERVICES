package com.nt.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.nt.beansCsrf.CSRF;
import com.nt.model.UserRolesTab;
import com.nt.service.ICompanyService;

@Controller
public class UserAuthSaveController {
	@Autowired
	private ICompanyService service;
	@Autowired
	private UserCsrf repo;
	@GetMapping("/home")
	public String home(@ModelAttribute("users") UserRolesTab tab) {
		return"userRegisterPage";
	}
	
	
	@PostMapping("/Save")
	public String userRegisterPage(@ModelAttribute("users") UserRolesTab tab,Map<String,Object> map) {
		int saveid=service.saveObject(tab);
		map.put("save", "value saved by id: "+saveid);
		return"userRegisterPage";
	}
	@ModelAttribute("roles")
	public List<String> userRoles() {
		
		return List.of("ADMIN","STUDENT","EMPLOYEE","College");
	}
	@GetMapping("/sucessLogOut")
	public String sucess() {
		return "logout";
	}
	@GetMapping("/denied")
	public String forUnAuthorized() {
		return "denied";
	}
	@GetMapping("/csrfGet")
	public String showCSRF(@ModelAttribute("csrf") CSRF csrf) {
		return "shoCsrfPage";
	}
	
	@PostMapping("/csrfTest")
     public String CSRF(@ModelAttribute("csrf") com.nt.beansCsrf.CSRF csrf) {
		System.out.println(csrf.getUname()+" "+csrf.getUpwd());
		repo.save(csrf);
		return"csrf";
	}

}
