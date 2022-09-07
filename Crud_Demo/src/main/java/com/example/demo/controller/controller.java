package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.Entity.entity;
import com.example.demo.Repository.Repository;

@Controller
public class controller {
	@Autowired
	private Repository repo;
	
	@GetMapping("/Home")
	public String HomePage()
	{
		return "Home";
	}
	
	
	@GetMapping("/register")
	public String RegisterPage(Model m)
	{
		m.addAttribute("obj",new entity());
		
		return "Register";
	}
	
	@PostMapping("/process_register")
	public String RegisterSuccessPage(@ModelAttribute("u1")entity e1)
	{
		repo.save(e1);
		
		return "Register_Success";
	}
	
	
	@GetMapping("/sign-in")
	public String SignINPage(Model m)
	{
		m.addAttribute("obj1",new entity());
		
		return "SignIN";
	}
	
	@PostMapping("/process_signIN")
	public String SIGNINSuccessPage(@ModelAttribute("u1")entity e1)
	{
		System.out.println("Hello World");
		int id=e1.getId();
		String s1=e1.getName();
		entity e=repo.findById(id).get();
		System.out.println("Retrievd name is"+e.getName());
		if(s1.contentEquals(e.getName()))
		return "Login_Success";
		else
		{
			e.setName(s1);
			repo.save(e);
		return "Something_Wrong";
		}
	}
	
	
	
	
	
}
