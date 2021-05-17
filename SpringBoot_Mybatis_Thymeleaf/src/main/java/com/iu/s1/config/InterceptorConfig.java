package com.iu.s1.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.iu.s1.interceptor.TestInterceptor;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

	@Autowired
	private TestInterceptor testInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// TODO Auto-generated method stub
		// Interceptor 용 bean을 등록
		// 어떤 url이 왔을 때 발동시킬건지 알려주는 역활을 한다.
		registry.addInterceptor(testInterceptor).addPathPatterns("/notice/**");
		WebMvcConfigurer.super.addInterceptors(registry);
	}
}
