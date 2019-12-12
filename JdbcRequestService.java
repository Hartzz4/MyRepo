package com.newproj;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class JdbcRequestService {

	private static String url="jdbc:mysql://localhost:3307/JSPEntry";
	private static String uname="localhost";
	private static String pwd="";
	static String query="insert into USER(Username,Password,Email,Contact) values (?,?,?,?)";
	
	public static void RegisterUser(ServClass user)
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,uname,pwd);
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getEmail());
			ps.setString(4, user.getContact());
			
			ps.executeUpdate();
			
			ps.close();
			con.close();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return;
	}
	
}
