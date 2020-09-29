package com.example.spring.mvc;

import javax.servlet.Filter;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;


public class MyAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
	
	@Override
	protected WebApplicationContext createRootApplicationContext() {		//equivalent to getRootConfigClasses()
		return null;
	}
	
	@Override
	protected WebApplicationContext createServletApplicationContext() {		//equivalent to getServletConfigClasses()
		XmlWebApplicationContext cxt = new XmlWebApplicationContext();
		cxt.setConfigLocation("/WEB-INF/MyAppConfig.xml");
		return cxt;
    }
    
    @Override
	protected String[] getServletMappings() {
		return new String[] { "/v1/*" };
	}
	
	@Override
	protected Filter[] getServletFilters() {
		return new Filter[] { new HiddenHttpMethodFilter(), new CharacterEncodingFilter() };
	}

	
	
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return null;
	}
}
