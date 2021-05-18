package com.iu.s1.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.iu.s1.interceptor.WriterInterceptor;

@Controller
public class WriterinterceptorConfig implements WebMvcConfigurer{

	@Autowired
	private WriterInterceptor writerInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// TODO Auto-generated method stub
		registry.addInterceptor(writerInterceptor)
				.addPathPatterns("/qna/update");
	}
}
