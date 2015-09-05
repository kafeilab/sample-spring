package edu.sample.spring.mvc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import edu.sample.spring.mvc.handler.interceptor.AMeasurementInterceptor;

@Configuration
@EnableWebMvc
@ComponentScan("edu.sample.spring.mvc")
// WebMvcConfigurerAdapter is use to register handler interceptor
public class WebConfiguration extends WebMvcConfigurerAdapter {
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(measurementInterceptor());
	}
	
	@Bean
	public AMeasurementInterceptor measurementInterceptor() {
		return new AMeasurementInterceptor();
	}
	
	@Bean
	public ViewResolver internalResourceViewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/jsp/");
		resolver.setSuffix(".jsp");
		return resolver;
	}

}
