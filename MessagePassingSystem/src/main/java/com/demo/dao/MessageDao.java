package com.demo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.demo.model.Message;

public class MessageDao {

	private Connection conn; 
	public MessageDao() 
	{ 
		try { 
			Class.forName("com.mysql.cj.jdbc.Driver"); 
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/newmydb", "root", "123456"); 
			} catch (Exception e) { 
				e.printStackTrace(); 
				} 
		}
	
	public boolean sendMessage(Message message) { 
		try { 
			String query = "insert into messages (uid, `from`, `to`, msg) values (?, ?, ?, ?)"; 
			PreparedStatement ps = conn.prepareStatement(query); 
			ps.setInt(1, message.getUid()); 
			ps.setString(2, message.getFrom()); 
			ps.setString(3, message.getTo()); 
			ps.setString(4, message.getMsg()); 
			ps.executeUpdate(); 
			return true; 
			} catch (SQLException e) { 
				e.printStackTrace(); 
				return false; 
				} 
		}
	
	public List<Message> getMessagesByEmail(String email) { 
		List<Message> messages = new ArrayList<>(); 
		try { 
			String query = "select * from messages where `to`=?"; 
			PreparedStatement ps = conn.prepareStatement(query); 
			ps.setString(1, email); 
			ResultSet rs = ps.executeQuery(); 
			while (rs.next()) { 
				Message message = new Message(); 
				message.setMid(rs.getInt("mid")); 
				message.setUid(rs.getInt("uid")); 
				message.setFrom(rs.getString("from")); 
				message.setTo(rs.getString("to")); 
				message.setMsg(rs.getString("msg")); 
				messages.add(message); 
				} 
			} catch (SQLException e) { 
				e.printStackTrace(); 
				} 
		return messages; 
		}
}
