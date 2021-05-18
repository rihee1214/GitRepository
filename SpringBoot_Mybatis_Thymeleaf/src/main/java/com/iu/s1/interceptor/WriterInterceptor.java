package com.iu.s1.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class WriterInterceptor implements HandlerInterceptor{

	//controller 종료 후
	//작성자를 출력
	//로그인 유저네임 출력
	
	//writerInterceptorconfig
	// /qna/update
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
							ModelAndView modelAndView) throws Exception {
		HttpSession session = request.getSession();
		session.getAttribute("member");
	}
}
