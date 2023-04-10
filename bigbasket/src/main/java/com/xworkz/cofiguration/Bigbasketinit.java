package com.xworkz.cofiguration;

import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class Bigbasketinit extends AbstractAnnotationConfigDispatcherServletInitializer implements WebMvcConfigurer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		System.out.println();
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		System.out.println("this is getServletConfigClasses");

		return new Class[] { BigbasketConfiguration.class };
	}

	@Override
	protected String[] getServletMappings() {
		System.out.println("this is getServletMappings");
		return new String[] { "/" };
	}

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		System.out.println("this is Default Servlet Handler Configurer");
		configurer.enable();
	}

}
