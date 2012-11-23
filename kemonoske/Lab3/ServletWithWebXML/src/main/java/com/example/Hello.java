package com.example;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Hello
 */
public class Hello extends HttpServlet{

	private PrintWriter out = null;
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		hello(request, response);
		
		
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		hello(request, response);
		
	}



	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		hello(request, response);
		
	}


	public void hello(HttpServletRequest request, HttpServletResponse response) throws IOException{
		

		out = response.getWriter();
		out.print(
			"<!DOCTYPE html>\n" + 
			"<html lang=\"en\">\n" + 
				"<head>" + 
					"<meta charset=\"utf-8\">\n" + 
					"<title>Hello World</title>\n" +
				"</head>\n" + 
				"<body>\n" +
					"<h1>Hello World</h1>\n" +
				"</body>\n" +
			"</html>"
				);
		
	}
	

	@Override
	public void destroy() {

		super.destroy();
		
		out.close();
		out = null;
		
	}

	
	
}

