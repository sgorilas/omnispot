/*
 * Disclaimer:
 * Copyright 2008 - KESDIP E.P.E & Stelios Gerogiannakis - All rights reserved.
 * eof Disclaimer
 * 
 * Date: Feb 2, 2009
 * @author <a href="mailto:sgerogia@gmail.com">Stelios Gerogiannakis</a>
 */

package com.kesdip.admin.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.springframework.web.context.support.XmlWebApplicationContext;

/**
 * Base class for all servlets wishing to have a hold of the current spring
 * context.
 * 
 * @author gerogias
 */
public abstract class BaseSpringContextServlet extends HttpServlet {

	/**
	 * The Spring context.
	 */
	private XmlWebApplicationContext springContext;

	@Override
	public void init() throws ServletException {
		springContext = new XmlWebApplicationContext();
		springContext.setServletContext(getServletContext());
		springContext
				.setConfigLocations(new String[] { "/WEB-INF/spring/application-context.xml" });
		springContext.refresh();
	}

	/**
	 * @return the springContext
	 */
	protected XmlWebApplicationContext getSpringContext() {
		return springContext;
	}
	
}