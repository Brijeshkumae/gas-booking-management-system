package Booking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class userPurchase {
String name;
String Phnno;
String Address;
String cyltype;
int price;
String Date;
String connectionid;

public userPurchase(String connectionid,String name, String phnno, String address, String cyltype, int price, String date) {
	super();
	this.connectionid =connectionid;
	this.name = name;
	Phnno = phnno;
	Address = address;
	this.cyltype = cyltype;
	this.price = price;
	Date = date;
}
public String getConnectionid() {
	return connectionid;
}
public void setConnectionid(String connecctionid) {
	this.connectionid = connecctionid;
}
public userPurchase() throws NumberFormatException, IOException, ClassNotFoundException, SQLException {
	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	
	int val=0;
	while(val==0)
	{
		System.out.println("1-purchase cylinder");
		System.out.println("2-show user Purchase Data");
		int choice=Integer.parseInt(br.readLine());
		switch(choice)
		{
		case 1:
			Connection con=Conn.getCon();
			String query="select * from purchase";
			PreparedStatement ps=con.prepareStatement(query);
			ResultSet rs=ps.executeQuery();
			rs.next();
			System.out.println("Enter connectionid ");
			String connectionid=br.readLine();
			System.out.println("Enter name");
			String name=br.readLine();
			System.out.println("phnno");
			String phnno=br.readLine();
			System.out.println("Enter address");
			String address=br.readLine();
			System.out.println("Enter the serial number of cylinder\n");
			System.out.println("SNO || Cylinder Type || Price");
			System.out.print(rs.getInt(1)+" ||");
			System.out.print(rs.getString(3)+" ||");
			System.out.print(rs.getInt(4)+" ||\n\n");
			int slno=Integer.parseInt(br.readLine());
			String query2="select * from purchase where slno=?";
			ps=con.prepareStatement(query2);
			ps.setInt(1,slno);
			rs=ps.executeQuery();
			rs.next();
			String cyltype=rs.getString(3);
			int price=rs.getInt(4);
			System.out.println("Enter Date");
			String date=br.readLine();
			userPurchase up=new userPurchase(connectionid,name,phnno,address,cyltype,price,date);
			userDao.insert(up);
			updateDataset.getUpdate();
			break;
		case 2:
			userDao.showUser();
			break;
		case 0:
			val=1;
			break;
		
		}
	}

}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getPhnno() {
	return Phnno;
}
public void setPhnno(String phnno) {
	Phnno = phnno;
}
public String getAddress() {
	return Address;
}
public void setAddress(String address) {
	Address = address;
}
public String getCyltype() {
	return cyltype;
}
public void setCyltype(String cyltype) {
	this.cyltype = cyltype;
}
public int getPrice() {
	return price;
}
public void setPrice(int price) {
	this.price = price;
}
public String getDate() {
	return Date;
}
public void setDate(String date) {
	Date = date;
}



}
