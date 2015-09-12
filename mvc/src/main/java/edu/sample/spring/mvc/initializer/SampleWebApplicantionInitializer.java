package edu.sample.spring.mvc.initializer;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import edu.sample.spring.mvc.config.ServiceConfiguration;
import edu.sample.spring.mvc.config.WebConfiguration;

/**
 * The initializer for the sample spring web mvc
 * @author Bunlong Taing
 *
 * @since Sep 5, 2015
 * @since 0.0.1
 * @version 0.0.1
 */
public class SampleWebApplicantionInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	/**
	 * Return null if no Root Application context
	 */
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class<?>[] { ServiceConfiguration.class };
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?>[] { WebConfiguration.class };
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] {"/"};
	}

}
