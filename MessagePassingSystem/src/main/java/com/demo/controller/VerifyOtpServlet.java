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
 * Servlet implementation class VerifyOtpServlet
 */
public class VerifyOtpServlet extends HttpServlet {
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
		String otp = request.getParameter("otp"); 
		HttpSession session = request.getSession(); 
		String generatedOtp = (String) session.getAttribute("generatedOtp"); if (otp.equals(generatedOtp)) {
			User user = userDao.getUserByEmail(email); 
			session.setAttribute("user", user); 
			response.sendRedirect("dashboard.jsp"); 
			} else { 
				response.getWriter().println("OTP verification failed. Please try again."); 
				}
	}

}
