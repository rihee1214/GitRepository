package com.iu.s1.interceptor;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.iu.s1.member.MemberVO;

@Component
public class TestInterceptor implements HandlerInterceptor{
	
	//controller 진입 시 실행
	@Override
	public boolean preHandle(HttpServletRequest request, 
							HttpServletResponse response, Object handler)throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Controller 진입");
		
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
		
		ClassPathResource classPathResource = new ClassPathResource("member");
		System.out.println(classPathResource.getPath());
		String path = classPathResource.getPath()+"/join";
		
		if(!result) {
			request.setAttribute("name", "data");
			RequestDispatcher view = request.getRequestDispatcher(path);
			view.forward(request, response);
		}
		
//		
//		request.setAttribute("name", "data");
//		RequestDispatcher view = request.getRequestDispatcher("view");
//		view.forward(request, response);
//		
//		if(!result) {
//			response.sendRedirect("/member/login");
//		}
		
		return result;
	}
	
	//contoller 종료 후 실행
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Controller 종료 후");
	}
	
	//클라이언트로 최종 전송 전
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("client 전송 전");
	}
}
