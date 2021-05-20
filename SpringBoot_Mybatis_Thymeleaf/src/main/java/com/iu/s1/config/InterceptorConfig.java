package com.iu.s1.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.iu.s1.interceptor.TestInterceptor;

@Configuration	//xml root-context, servlet-context
public class InterceptorConfig implements WebMvcConfigurer {

	@Autowired	//인터셉터 주입을 위함
	private TestInterceptor testInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// TODO Auto-generated method stub
		// Interceptor 용 bean을 등록
		// 어떤 url이 왔을 때 주입시킨 interceptor를 발동시킬건지 알려주는 역활을 한다.
		registry.addInterceptor(testInterceptor).addPathPatterns("/notice/**").addPathPatterns("/qna/**").excludePathPatterns("/notice/select");
		//여러개를 .으로 이어붙일 수도 있고 addPathPatterns는 interceptor추가 
		//excludePathPatterns는 해당 패턴에서 interceptor 적용을 제외시키는 것을 말한다.
		//이러한 방식을 method chaining이라고 한다.
		
		//registry.addInterceptor를 다시 불러서 다른 인터셉터를 넣고 추가할 수 있다.
		
		//WebMvcConfigurer.super.addInterceptors(registry);
	}
}
