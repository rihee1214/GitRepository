package com.iu.s1.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

	@Override
	public void configure(WebSecurity web) throws Exception {
		// Security를 제외하는 세팅
		web.ignoring()
		.antMatchers("/resources/**")
		.antMatchers("/images/**")
		.antMatchers("/css/**")
		.antMatchers("/js/**")
		.antMatchers("/vendor/**")
		.antMatchers("/favicon/**");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {	//메서드 체이닝으로 계속해서 연결해서 사용한다.
		// URL에 따른 로그인, 권한설정
		http
			.cors().and()		//권한설정
			.csrf().disable()
			.authorizeRequests()
			.antMatchers("/").permitAll()
			.antMatchers("/notice/list", "/notice/select").permitAll()
			.antMatchers("/notice/**").hasRole("ADMIN")
			.antMatchers("/qna/**").hasAnyRole("ADMIN", "MEMBER")
			.antMatchers("/qna/select").permitAll()
			.antMatchers("/member/logout").permitAll()	//login은 이미 로그인 처리가 되어 있기 때문에 permitAll에 추가하지 않아도 된다.
			.antMatchers("/member/**").hasAnyRole("MEMBER","ADMIN")
			.anyRequest().authenticated()
		.and()//로그인 설정 permit되지 않은 경우 login 페이지로 바로 넘어가게 된다.
			.formLogin()	//로그인 페이지를 따로 만들지 않아도 기본 내장된 폼으로 이동을 한다. 개발자가 만든 로그인 폼을 쓰려면 이렇게 작성 해야한다.
			.loginPage("/member/login").permitAll();	//누구나 접근 가능하게 처리해 주었다.
	//	.and()
	//		.logout();		//로그아웃 처리를 위해 처리하는 구문이 또 따로 있다.
	}
}
