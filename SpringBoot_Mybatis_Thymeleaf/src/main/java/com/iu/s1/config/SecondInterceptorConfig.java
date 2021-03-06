package com.iu.s1.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.iu.s1.interceptor.SecondInterceptor;

@Configuration
public class SecondInterceptorConfig implements WebMvcConfigurer{

	@Autowired
	private SecondInterceptor secondInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(secondInterceptor).addPathPatterns("/notice/**")
				.order(1);
				// 순서 결정
				// 숫자가 낮을수록 우선순위(먼저 실행)
	}
}
