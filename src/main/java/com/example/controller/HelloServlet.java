package com.example.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * HelloServlet - Simple servlet to demonstrate basic servlet functionality
 */
@WebServlet("/hello")
public class HelloServlet extends HttpServlet {
    
    private static final Logger logger = LoggerFactory.getLogger(HelloServlet.class);
    private static final long serialVersionUID = 1L;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        logger.info("HelloServlet called with GET request");
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        try {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<meta charset='UTF-8'>");
            out.println("<title>Hello Servlet</title>");
            out.println("<style>");
            out.println("body { font-family: Arial, sans-serif; margin: 40px; }");
            out.println(".container { max-width: 600px; margin: 0 auto; }");
            out.println("h1 { color: #333; }");
            out.println("p { color: #666; line-height: 1.6; }");
            out.println("</style>");
            out.println("</head>");
            out.println("<body>");
            out.println("<div class='container'>");
            out.println("<h1>Welcome to Hello Servlet!</h1>");
            out.println("<p>This is a simple Java servlet response.</p>");
            out.println("<p><strong>Request Method:</strong> " + request.getMethod() + "</p>");
            out.println("<p><strong>Server Info:</strong> " + getServletContext().getServerInfo() + "</p>");
            out.println("<hr>");
            out.println("<p><a href='/'>Back to Home</a></p>");
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        logger.info("HelloServlet called with POST request");
        doGet(request, response);
    }
}
