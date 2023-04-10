package com.xworkz.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan("com.xworkz")
public class busConfiguration {

	public busConfiguration() {
		System.out.println("created configuration......");
	}

	@Bean
	public ViewResolver resolver() {
		return new InternalResourceViewResolver("/", ".jsp");
	}

}
