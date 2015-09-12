package edu.sample.spring.mvc.config;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import edu.sample.spring.mvc.exception.ReservationNotAvailableException;
import edu.sample.spring.mvc.handler.interceptor.AMeasurementInterceptor;

@Configuration
@EnableWebMvc
@ComponentScan("edu.sample.spring.mvc.controller")
// WebMvcConfigurerAdapter is use to register handler interceptor
public class WebConfiguration extends WebMvcConfigurerAdapter {
	
	@Autowired
	private ContentNegotiationManager contentNegotiationManager;
	
	@Override
	public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
		Map<String, MediaType> mediaTypes = new HashMap<String, MediaType>();
		mediaTypes.put("html", MediaType.TEXT_HTML);
//		mediaTypes.put("pdf", new MediaType("application/pdf"));
//		mediaTypes.put("xls", new MediaType("application/vnd.ms-excel"));
		mediaTypes.put("xml", MediaType.TEXT_XML);
		mediaTypes.put("json", MediaType.APPLICATION_JSON);
		configurer.mediaTypes(mediaTypes);
	}
	
	@Bean
	public ContentNegotiatingViewResolver contentNegotiatingViewResolver() {
		ContentNegotiatingViewResolver viewResolver = new ContentNegotiatingViewResolver();
		viewResolver.setContentNegotiationManager(contentNegotiationManager);
		return viewResolver;
	}
	
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
	
	/* 
	 * ---------------------------
	 * Mapping Exceptions to Views
	 * ---------------------------
	 */
	
	@Override
	public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> exceptionResolvers) {
		exceptionResolvers.add(handlerExceptionResolver());
	}
	
	@Bean
	public HandlerExceptionResolver handlerExceptionResolver() {
		Properties exceptionMapping = new Properties();
		exceptionMapping.setProperty(ReservationNotAvailableException.class.getCanonicalName(), "reservationNotAvailable");
		
		SimpleMappingExceptionResolver exceptionResolver = new SimpleMappingExceptionResolver();
		exceptionResolver.setExceptionMappings(exceptionMapping);
		exceptionResolver.setDefaultErrorView("error");;
		return exceptionResolver;
	}

}
