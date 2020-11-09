package com.aem.fibseries.core.fibnacservlet;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletException;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.osgi.framework.Constants;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.aem.fibseries.core.fibnacbean.FibnaciBean;
import com.aem.fibseries.core.fibnaciservice.FibnaciSeries;


@Component(service = Servlet.class, property = { Constants.SERVICE_DESCRIPTION + "=FibnacSeries Servlet",
		"sling.servlet.methods=" + HttpConstants.METHOD_GET, "sling.servlet.paths=" + "/bin/series" })
public class FibnacServlet extends SlingSafeMethodsServlet {
		private static final long serialVersionUID = 1L;
	Logger log=LoggerFactory.getLogger(FibnacServlet.class);
	int result;
	StringBuilder sb;
	String str;
	
	@Reference
	FibnaciSeries fibnacSeries;
	@Override
	protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doGet(request, response);
		
		String first = request.getParameter("firstNumber");
		String second = request.getParameter("secondNumber");
		String limit = request.getParameter("limit");
		int limits = 0;
      
		log.info("calling FibnacServlet");
		
		
		//FibnaciSeries fibnacSeries = new FibImpl();
		FibnaciBean b = new FibnaciBean();
		if (limits == 0) {
			b.setLimit(10);

			try {

				limits = Integer.parseInt(limit);
			} catch (Exception e) {
				
			}
		}
		if (second == null) {
			b.setSecondNumber("1");
		}

		if (first != null && second != null && (limits >= 0 && limits <= 25)) {			
			sb=fibnacSeries.getFibnaci(first, second, limits);			
		} else if (first != null && second != null && (0 < limits && limits > 25)) {
			 str="Limit Should Not be Exceeds More Than 25 !!";
			 sb.append(str);

		} else if (first != null && second == null && (limits > 0 && limits <= 25)) {	
			b.setSecondNumber("1");
			b.getSecondNumber();
		   sb=fibnacSeries.getFibnaci(first, b.getSecondNumber(), limits);

		}else if(first !=null && (limits>=0 && limits>=25)) {
			str="Limit Should Not be Exceeds More Than 25 !!";
			sb.append(str);
		}else if(first !=null)  {
			b.setSecondNumber("1");
			b.setLimit(10);
			b.getSecondNumber();
			b.getLimit();
			sb=fibnacSeries.getFibnaci(first, b.getSecondNumber(), b.getLimit());

		}
		 response.getWriter().println(sb.toString());
		
		
	}
	
	

}
