package Booking;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class userDao
{
	public static void insert(userPurchase up) throws ClassNotFoundException, SQLException
	{
		Connection con=Conn.getCon();
		String query="insert into user(connectionid,name,Phnno,Adress,cyltype,price,Date)values(?,?,?,?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setString(1, up.getConnectionid());
		ps.setString(2, up.getName());
		ps.setString(3, up.getPhnno());
		ps.setString(4, up.getAddress());
		ps.setString(5, up.getCyltype());
		ps.setInt(6,up.getPrice());
		ps.setString(7,up.getDate());
		ps.executeUpdate();
	}
	public static void showUser() throws SQLException, ClassNotFoundException
	{
		Connection con=Conn.getCon();
		String query="select *from user";
		PreparedStatement ps=con.prepareStatement(query);
		ResultSet set=ps.executeQuery(query);
		while(set.next())
		{
			int slno=set.getInt(1);
			String connectionid=set.getString(2);
			String name=set.getString(3);
			String  Phnno=set.getString(4);
			String Address=set.getString(5);
			String cyltype=set.getString(6);
			int price=set.getInt(7);
			String Date=set.getString(8);
			System.out.println(" slno  "+slno+"  \nconnectionid  "+connectionid+"  \nname  "+name+"  \nPhnno  "+Phnno+"  \nAddress  "+Address+"  \ncyltype  "+cyltype+"  \nprice  "+price+"  \ndate  "+Date);
			System.out.println("----------------------------");
	}
}
	
}