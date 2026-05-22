package com.example.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.example.model.User;
import com.example.service.UserService;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * UserServlet - Handles user-related operations
 */
@WebServlet("/api/user")
public class UserServlet extends HttpServlet {
    
    private static final Logger logger = LoggerFactory.getLogger(UserServlet.class);
    private static final long serialVersionUID = 1L;
    private UserService userService = new UserService();
    private Gson gson = new Gson();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        logger.info("UserServlet GET request received");
        
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        try {
            String action = request.getParameter("action");
            
            if ("list".equals(action)) {
                response.setStatus(HttpServletResponse.SC_OK);
                out.print(gson.toJson(userService.getAllUsers()));
                logger.info("Returned all users");
            } else if ("get".equals(action)) {
                String idStr = request.getParameter("id");
                if (idStr != null) {
                    int id = Integer.parseInt(idStr);
                    User user = userService.getUserById(id);
                    if (user != null) {
                        response.setStatus(HttpServletResponse.SC_OK);
                        out.print(gson.toJson(user));
                    } else {
                        response.setStatus(HttpServletResponse.SC_NOT_FOUND);
                        out.print(gson.toJson(new ApiResponse("error", "User not found")));
                    }
                }
            } else {
                response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                out.print(gson.toJson(new ApiResponse("error", "Invalid action")));
            }
        } catch (Exception e) {
            logger.error("Error processing GET request", e);
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            out.print(gson.toJson(new ApiResponse("error", e.getMessage())));
        } finally {
            out.close();
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        logger.info("UserServlet POST request received");
        
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        try {
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            String city = request.getParameter("city");
            
            if (name != null && email != null && city != null) {
                User user = new User(0, name, email, city, LocalDateTime.now());
                User createdUser = userService.createUser(user);
                response.setStatus(HttpServletResponse.SC_CREATED);
                out.print(gson.toJson(createdUser));
                logger.info("User created: " + createdUser.getName());
            } else {
                response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                out.print(gson.toJson(new ApiResponse("error", "Missing required parameters")));
            }
        } catch (Exception e) {
            logger.error("Error processing POST request", e);
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            out.print(gson.toJson(new ApiResponse("error", e.getMessage())));
        } finally {
            out.close();
        }
    }
    
    /**
     * Simple API response wrapper
     */
    private static class ApiResponse {
        public String status;
        public String message;
        
        public ApiResponse(String status, String message) {
            this.status = status;
            this.message = message;
        }
    }
}
