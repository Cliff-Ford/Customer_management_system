package com.cliff.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.cliff.pojo.User;

public class LoginInterceptor implements HandlerInterceptor{
	@Override
	public boolean preHandle(HttpServletRequest request,HttpServletResponse response,Object handler) throws Exception{
		String url = request.getRequestURI();		
		//已经登录，放行
		HttpSession session = request.getSession();		
		User user = (User) session.getAttribute("USER_SESSION");
		if(user != null) {
			return true;
		}
		System.out.println("不放行" + url);
		//拦截，跳转到登录页面
		request.getRequestDispatcher("/jsp/login.jsp").forward(request, response);
		return false;
	}
	@Override
	public void postHandle(HttpServletRequest request,HttpServletResponse response,Object handler,ModelAndView modelAndView) throws Exception{
		
	}
	@Override
	public void afterCompletion(HttpServletRequest request,HttpServletResponse response,Object handler,Exception exception) throws Exception{
		
	}
}
