package edu.sample.spring.mvc.handler.interceptor;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class ExtensionInterceptor extends HandlerInterceptorAdapter {
	
	private static final String REPORT_NAME = "ReservationSummary";
	private static final String EXTENSION_PDF = ".pdf";
	private static final String EXTENSION_EXCEL = ".xls";

	/*
	 * Change the file name of the request
	 * Add the current date as the file name
	 */
	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler, 
			ModelAndView modelAndView) throws Exception {
		
		String reportName = null;
		DateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
		if (request.getServletPath().endsWith(EXTENSION_PDF)) {
			reportName = REPORT_NAME + "_" +
					df.format(new Date()) + EXTENSION_PDF;
		}
		if (request.getServletPath().endsWith(EXTENSION_EXCEL)) {
			reportName = REPORT_NAME + "_" +
					df.format(new Date()) + EXTENSION_EXCEL;
		}
		if (reportName != null) {
			response.setHeader("Content-Disposition", "attachment; filename=" + reportName);
		}
	}
	
}
