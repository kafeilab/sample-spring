package edu.sample.spring.mvc.handler.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AMeasurementInterceptor extends HandlerInterceptorAdapter {
	
	private static final String START_TIME = "startTime";

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		
		long startTime = System.currentTimeMillis();
		request.setAttribute(START_TIME, startTime);
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		long startTime = (Long) request.getAttribute(START_TIME);
		request.removeAttribute(START_TIME);
		
		long endTime = System.currentTimeMillis();
		modelAndView.addObject("handlingTime", endTime - startTime);
	}
}
