package com.demo.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.demo.dao.MessageDao;
import com.demo.dao.UserDao;
import com.demo.model.Message;

/**
 * Servlet implementation class SendMsgServlet
 */
public class SendMsgServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private MessageDao messageDao; 
	public void init() { 
		messageDao = new MessageDao(); 
		}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int uid = Integer.parseInt(request.getParameter("uid")); 
		String from = request.getParameter("from"); 
		String to = request.getParameter("to"); 
		String msg = request.getParameter("msg"); 
		Message message = new Message(); 
		message.setUid(uid); 
		message.setFrom(from); 
		message.setTo(to); 
		message.setMsg(msg); 
		if (messageDao.sendMessage(message)) { 
			response.sendRedirect("viewMessages.jsp"); 
			} else { 
				response.getWriter().println("Message sending failed."); 
				}
	}

}
