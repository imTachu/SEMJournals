package com.sem.journal.config;

import javax.servlet.Filter;
import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.multipart.support.MultipartFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.sem.journal.filters.CorsFilter;

public class MvcWebApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] { WebMvcConfig.class, PersistencesJPAConfig.class, SecurityConfiguration.class };
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return null;
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] {"/"};
	}
	
	@Override
	protected Filter[] getServletFilters() {
		return new Filter[]{new CorsFilter(),new MultipartFilter()};
	}
	
	@Override
	protected void customizeRegistration(Dynamic registration) {
		MultipartConfigElement mpp = new MultipartConfigElement("/tmp", 25 * 1024 * 1024, 125 * 1024 * 1024, 1 * 1024 * 1024); 
		registration.setMultipartConfig(mpp);
	}

}