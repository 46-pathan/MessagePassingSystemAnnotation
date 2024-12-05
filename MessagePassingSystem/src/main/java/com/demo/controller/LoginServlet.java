package com.demo.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.demo.dao.UserDao;
import com.demo.model.User;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UserDao userDao; 
	public void init() { 
		userDao = new UserDao(); 
		}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email = request.getParameter("email"); 
		User user = userDao.getUserByEmail(email); 
		if (user != null) { 
			HttpSession session = request.getSession(); 
			session.setAttribute("user", user); 
			response.sendRedirect("dashboard.jsp"); 
			} else { 
				response.getWriter().println("Login failed. User not found."); 
			}
	}

}
