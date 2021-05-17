package com.iu.s1.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.iu.s1.member.MemberVO;

@Component
public class TestInterceptor implements HandlerInterceptor{
	
	@Override
	public boolean preHandle(HttpServletRequest request, 
							HttpServletResponse response, Object handler)throws Exception {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		Object object = session.getAttribute("member");
		MemberVO memberVO = null;
		boolean result = false;
		
		if(object != null) {
			memberVO = (MemberVO)object;
			if(memberVO.getUserName().equals("admin")) {
				result = true;
			}
		}
		
		if(!result) {
			response.sendRedirect("/member/login");
		}
		
		return result;
	}
}
