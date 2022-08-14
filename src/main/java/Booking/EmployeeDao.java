package Booking;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class EmployeeDao {
	public static void insert(Employee Em) throws ClassNotFoundException, SQLException {
			Connection con=Conn.getCon();
			String query="insert into employe(Email,name,password)values(?,?,?)";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, Em.getEmail());
			ps.setString(2, Em.getName());
			ps.setString(3, Em.getPassword());
			ps.executeUpdate();
			
			
	}
	public static void delete(String name)throws ClassNotFoundException, SQLException {
		Scanner sc=new Scanner(System.in);
		Connection con=Conn.getCon();
		String query="delete from employe where name=?";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setString(1,name);
		ps.executeUpdate();
		
	}
	public static void showData() throws ClassNotFoundException, SQLException
	{
		Connection con=Conn.getCon();
		String query="select *from employe";
		PreparedStatement ps=con.prepareStatement(query);
		ResultSet set=ps.executeQuery(query);
		while(set.next())
		{
			int slno=set.getInt(1);
			String Email=set.getString(2);
			String  name=set.getString(3);
			String password=set.getString(4);
			System.out.println("slno "+slno+" \nEmail "+Email+" \nname "+name+" \npassword "+password);
			System.out.println("----------------------------");
		}
		
	}
	public static void updateRecord(int val,String update,int slno) throws ClassNotFoundException, SQLException
	{
		Connection con=Conn.getCon();
		if(val==1)
		   {
			String query="update Employe set name=? where slno=?";
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1, update);
			ps.setInt(2, slno);
			ps.executeUpdate();
			System.out.println("Details Updated!");
			}
		else if(val==2)
		{
			String query="update Employe set Email=? where slno=?";
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1, update);
			ps.setInt(2, slno);
			ps.executeUpdate();
			}
		else if(val==3)
		{
			String query="update Employe set password= ? where slno=?";
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1, update);
			ps.setInt(2, slno);
			ps.executeUpdate();
		}
		else
		{
			System.out.println("please enter correct value");
		}
		
	}
	
	
}
