package com.simple;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class SimpleServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();

		response.setContentType("text/html");

		out.println("<html>");
		out.println("<head><title>Simple Servlet</title></head>");
		out.println("<body>");
		out.println("<hr><h1 align = center>");
		out.println("Hello World</h1>");
		out.println("</body>");
		out.println("</html>");
	}
}