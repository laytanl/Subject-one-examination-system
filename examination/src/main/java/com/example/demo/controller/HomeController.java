package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	@GetMapping("/Login")
	public String login() {
		return "Login.html";
	}
	@GetMapping("/Register")
	public String register() {
		return "Register.html";
	}
	@GetMapping("/Admin")
	public String admin() {
		return "Admin.html";
	}
	
	@GetMapping("/item")
	public String item() {
		return "item.html";
	}
	@GetMapping("/userhome")
	public String userhome() {
		return "userhome.html";
	}
	@GetMapping("/answer")
	public String answer() {
		return "answer.html";
	}
	@GetMapping("/grade")
	public String grade() {
		return "grade.html";
	}
}
