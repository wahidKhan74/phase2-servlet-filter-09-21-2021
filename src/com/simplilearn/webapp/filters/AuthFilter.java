package com.simplilearn.webapp.filters;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter(filterName="auth2", urlPatterns = "/auth")
public class AuthFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("-- Filter Initialized --");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		// request params
		String userEmail = request.getParameter("useremail");
		String userPassword = request.getParameter("password");

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.print("<html><body>");
		
		if (userEmail.equals("") && userPassword.equals("")) {
			out.println("<h1 style='color:red'>Login Failed  * Required filled are missing! </h1>");
		} else {
			if (userEmail.equals("admin@gmail.com") && userPassword.equals("admin@123")) {
				// next pass to servlet program
				chain.doFilter(request, response);
			} else {
				out.println("<h1 style='color:red'>Login Failed * Invalid credntials </h1>");
			}
		}
		
	}

	@Override
	public void destroy() {
		System.out.println("-- Filter Destoryed ! --");

	}

}
