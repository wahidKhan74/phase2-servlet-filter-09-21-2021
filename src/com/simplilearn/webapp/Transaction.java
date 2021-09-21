package com.simplilearn.webapp;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/auth")
public class Transaction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Transaction() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		// response.sendRedirect("login.html");
		request.getRequestDispatcher("index.html").include(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("index.html").include(request, response);
		request.getRequestDispatcher("success.html").include(request, response);
	}

}
