package com.example.demo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.User;
import com.example.demo.mapper.UserMapper;

@RestController()
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserMapper mapper;
	int m;
	int n;
	int grade;
	@PostMapping("/register")
	public String register( @RequestBody User u) {
		
		String name=mapper.findname(u.getName()); 
		if(name!=null) {
			m=0;
		}
		else {
			mapper.add(u);
			m=1;
		}
		return "ok";
	}
	
	@GetMapping("/registername")
	public int register() {
		return m;
	}
	
	@PostMapping("/login")
	public String login(@RequestBody User u,HttpSession session) {
		
		User u1=mapper.findinfo(u.getName());
		
		if(u1==null) {
			n=0;
		}else if(u1.getPority()!=u.getPority()) {
			n=0;
		}else if(!(u1.getPassword().equals(u.getPassword()))) {
			n=1;
		}else {
			n=2;
			session.setAttribute("user", u.getName());
		}
		return "ok";
	}
	
	@GetMapping("/logininfo")
	public int logininfo() {
		return n;
	}
	
	@GetMapping("/session")
	public String session(HttpSession session) {
		return (String) session.getAttribute("user");
	}
	
	@PostMapping("/grade")
	public String grade(@RequestBody User user) {
	
		mapper.updategrade(user.getGrade(), user.getName());
		return "ok";
	}
	//通过用户名获取成绩
	@PostMapping("/usergrade")
	public String usergrade(@RequestBody User u) {
		User u1=mapper.findgrade(u.getName());
		if(u1==null) {
			
		}
		else {
		grade=u1.getGrade();
		}
		return "ok";
	}
	
	@RequestMapping("/usergrade")
	public int getusergrade() {
		return grade;
	}
	
}
