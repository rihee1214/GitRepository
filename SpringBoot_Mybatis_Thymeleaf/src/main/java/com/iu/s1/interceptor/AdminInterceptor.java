package com.iu.s1.interceptor;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ModelAndViewDefiningException;

import com.iu.s1.member.MemberVO;

@Component
public class AdminInterceptor implements HandlerInterceptor{

	//controller 진입 전 admin인지 판별
	//admin이면 진행
	//아니라면
	//1. login form으로 리다이렉트
	//2. 권한이 없음 alert띄우고 확인 누르면 index로 이동
	
	@Override
	public boolean preHandle(HttpServletRequest request,
							HttpServletResponse response, Object handler)throws Exception {
		
		//method 형식 구하기
		String method = request.getMethod();
		
		HttpSession session = request.getSession();
		MemberVO memberVO = new MemberVO();
		memberVO.setUserName((String)session.getAttribute("member"));
		
		boolean result = (memberVO.getUserName()!=null&&memberVO.getUserName().equals("admin"));
		
		System.out.println(memberVO);
		
		if(!result) {
//			//1. 로그인 폼으로 이동	
//			response.sendRedirect("/member/login");
			
			ModelAndView mav = new ModelAndView();
			mav.addObject("msg", "권한이 필요합니다.");
			mav.addObject("path", "/member/login");
			mav.setViewName("forward:/common/result");
			throw new ModelAndViewDefiningException(mav);
			
//			request.setCharacterEncoding("UTF-8");
//			request.setAttribute("msg", "권한이 필요합니다.");
//			request.setAttribute("path", "../member/login");
//			
//			request.getRequestDispatcher("/common/result.html").forward(request, response);
		}
		
		
		return result;
	}
	
}
