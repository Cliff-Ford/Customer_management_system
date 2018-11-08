package com.cliff.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


import com.cliff.pojo.User;
import com.cliff.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	//�û���¼
	@PostMapping(value="/login")
	public String login(String user_code,String user_password,Model model,HttpSession session,HttpServletResponse response) throws IOException {
		System.out.println(user_code);
		System.out.println(user_password);
		User u = new User();
		u.setUser_code(user_code);
		u.setUser_password(user_password);
		User user = userService.findUser(u);
		//��½�ɹ�
		if(user != null) {
			session.setAttribute("USER_SESSION", user);
			return "redirect:customerManager/list";
		}
		//��½ʧ��
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().write("<script>alert('�û��������벻ƥ�䣡');</script>");
		response.getWriter().flush();
		return "login";
	}
	@GetMapping("/login")
	public String toLogin() {
		return "login";
	}
	@GetMapping(value="/error")
	public String toError() {
		return "error";
	}
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		//�����¼��Ϣ
		session.invalidate();
		return "redirect:login";
	}
}
