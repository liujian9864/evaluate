package com.ecut.teachingevalutionsystem.config;

import com.ecut.teachingevalutionsystem.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class LoginInterceptorConfigurer
	implements WebMvcConfigurer {
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		HandlerInterceptor interceptor
			= new LoginInterceptor();
		
		List<String> excludeList = new ArrayList<>();

		excludeList.add("/login");
		excludeList.add("/index");

		excludeList.add("/bootstrap/**");
		excludeList.add("/images/**");
		excludeList.add("/css/**");
		excludeList.add("/js/**");
		
		registry.addInterceptor(interceptor)
			.addPathPatterns("/**")
			.excludePathPatterns(excludeList);
	}

}







