package com.iu.s1.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.iu.s1.member.MemberMapper;
import com.iu.s1.member.MemberVO;

@Component
public class MemberIdInterceptor implements HandlerInterceptor{

	@Autowired
	private MemberMapper memberMapper;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String username = request.getParameter("userName");
		
		request.login(username, username);
		//인터셉터에서도 mapper는 호출이 가능하다.
		MemberVO memberVO = new MemberVO();
		memberVO.setUserName(username);
		memberMapper.getCheck(memberVO);
		
		return true;
	}
}
