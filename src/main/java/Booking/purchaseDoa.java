package Booking;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class purchaseDoa {
	public static void insertPurchase(purchase pc) throws ClassNotFoundException, SQLException
	{
		Connection con=Conn.getCon();
		String query="insert into purchase(Date,cyltype,price,quantity,totalamt)values(?,?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setString(1, pc.getDate());
		ps.setString(2, pc.getCyltype());
		ps.setInt(3, pc.getPrice());
		ps.setInt(4, pc.getQuantity());
		ps.setInt(5,pc.getTotalamt());
		ps.executeUpdate();
	}
	public static void showpurchase() throws SQLException, ClassNotFoundException
	{
		Connection con=Conn.getCon();
		String query="select *from purchase";
		PreparedStatement ps=con.prepareStatement(query);
		ResultSet set=ps.executeQuery(query);
		while(set.next())
		{
			int slno=set.getInt(1);
			String Date=set.getString(2);
			String  cyltype=set.getString(3);
			int price=set.getInt(4);
			int quantity=set.getInt(5);
			int totalamt=set.getInt(6);
			System.out.println("slno "+slno+" \nDate "+Date+" \nPrice "+price+" \nQuantity "+quantity+"\nTotalamt"+totalamt);
			System.out.println("----------------------------");
	}
	}
}
	


