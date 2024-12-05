package com.demo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.demo.model.User;

public class UserDao {
	private Connection conn; 
	public UserDao() { 
		try { 
			Class.forName("com.mysql.cj.jdbc.Driver"); 
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/newmydb", "root", "123456"); 
			} catch (Exception e) { 
				e.printStackTrace(); 
				} 
		}
	
	public boolean registerUser(User user) { 
		try { 
			String query = "insert into users (fname, lname, email, mobile) values (?, ?, ?, ?)"; 
			PreparedStatement ps = conn.prepareStatement(query); 
			ps.setString(1, user.getFname()); 
			ps.setString(2, user.getLname()); 
			ps.setString(3, user.getEmail()); 
			ps.setString(4, user.getMobile()); 
			ps.executeUpdate(); 
			return true; 
			} catch (SQLException e) { 
				e.printStackTrace(); 
				return false; 
				} 
		}
	
	public User getUserByEmail(String email) { 
		try { 
			String query = "select * from users where email=?"; 
			PreparedStatement ps = conn.prepareStatement(query); 
			ps.setString(1, email); 
			ResultSet rs = ps.executeQuery(); 
			if (rs.next()) { 
				User user = new User(); 
				user.setUid(rs.getInt("uid")); 
				user.setFname(rs.getString("fname")); 
				user.setLname(rs.getString("lname")); 
				user.setEmail(rs.getString("email"));
				user.setMobile(rs.getString("mobile")); 
				return user; 
				} 
			} catch (SQLException e) { 
				e.printStackTrace(); 
				} 
		return null; 
		}
	
	public boolean updateUser(User user) { 
		try { 
			String query = "update users set fname=?, lname=?, email=?, mobile=? where uid=?"; 
			PreparedStatement ps = conn.prepareStatement(query); 
			ps.setString(1, user.getFname()); 
			ps.setString(2, user.getLname()); 
			ps.setString(3, user.getEmail()); 
			ps.setString(4, user.getMobile()); 
			ps.setInt(5, user.getUid()); 
			ps.executeUpdate(); 
			return true; 
			} catch (SQLException e) { 
				e.printStackTrace(); 
				return false; 
				} 
		}
	
	public List<User> getAllUsers() { 
		List<User> users = new ArrayList<>(); 
		try { 
			String query = "select * from users"; 
			PreparedStatement ps = conn.prepareStatement(query); 
			ResultSet rs = ps.executeQuery(); 
			while (rs.next()) { 
				User user = new User(); 
				user.setUid(rs.getInt("uid")); 
				user.setFname(rs.getString("fname")); 
				user.setLname(rs.getString("lname")); 
				user.setEmail(rs.getString("email")); 
				user.setMobile(rs.getString("mobile")); 
				users.add(user); 
				} 
			} catch (SQLException e) { 
				e.printStackTrace(); 
				} 
		return users; 
		}

}
