package com.demo.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

import com.demo.dao.MessageDao;
import com.demo.model.Message;
import com.demo.model.User;

/**
 * Servlet implementation class ViewMessagesServlet
 */
public class ViewMessagesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MessageDao messageDao; 
	public void init() { 
		messageDao = new MessageDao(); 
		}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(); 
		User user = (User) session.getAttribute("user"); 
		if (user != null) { 
			List<Message> messages = messageDao.getMessagesByEmail(user.getEmail()); 
			request.setAttribute("messages", messages); 
			request.getRequestDispatcher("viewMessages.jsp").forward(request, response); 
			} else { 
				response.sendRedirect("login.jsp"); 
			}
	}

}
