package com.iu.s1.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.iu.s1.interceptor.AdminInterceptor;

@Configuration
public class AdminInterceptorConfig implements WebMvcConfigurer{

	@Autowired
	private AdminInterceptor adminInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		//registry.addInterceptor(adminInterceptor).addPathPatterns("/notice/**")
		//										.excludePathPatterns("/notice/select")
		//										.excludePathPatterns("/notice/list");
	}
	
}
