package com.demo.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.demo.dao.UserDao;
import com.demo.model.User;

/**
 * Servlet implementation class EditProfileServlet
 */
public class EditProfileServlet extends HttpServlet {
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
		int uid = Integer.parseInt(request.getParameter("uid")); 
		String fname = request.getParameter("fname"); 
		String lname = request.getParameter("lname"); 
		String email = request.getParameter("email"); 
		String mobile = request.getParameter("mobile"); 
		User user = new User(); 
		user.setUid(uid); 
		user.setFname(fname); 
		user.setLname(lname); 
		user.setEmail(email); 
		user.setMobile(mobile); 
		if (userDao.updateUser(user)) { 
			response.sendRedirect("dashboard.jsp"); 
			} else { 
				response.getWriter().println("Profile update failed."); 
				}
	}
	

}
