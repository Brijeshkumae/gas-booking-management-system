package Booking;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conn {
	public static Connection getCon() throws ClassNotFoundException,SQLException
	{
		Connection con=null;
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/gas","root","Birju@123");
		return con;	
	}
}