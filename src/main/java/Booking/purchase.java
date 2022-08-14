package Booking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

public class purchase {
	String Date;
    String cyltype;
    int price;
    int quantity;
    int totalamt;
    
	public purchase(String date, String cyltype, int price, int quantity, int totalamt) {
		super();
		Date = date;
		this.cyltype = cyltype;
		this.price = price;
		this.quantity = quantity;
		this.totalamt = totalamt;
	}
	public purchase() throws NumberFormatException, IOException, ClassNotFoundException, SQLException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int val=0;
		while (val==0)
		{
			System.out.println("1-insert purchase Details");
			System.out.println("2-show purchase Data");
			int choice=Integer.parseInt(br.readLine());
			switch(choice)
			{
			case 1:
				System.out.println("Enter date");
				String date=br.readLine();
				System.out.println("Enter cyltype");
				String cyltype=br.readLine();
				System.out.println("Enter price");
				int price=Integer.parseInt(br.readLine());
				System.out.println("Enter quantity");
				int quantity=Integer.parseInt(br.readLine());
				int totalamt=price*quantity;
				purchase pc=new purchase(date,cyltype,price,quantity,totalamt);
				purchaseDoa.insertPurchase( pc);
				
				break;
			case 2:
				purchaseDoa.showpurchase();
				break;
			case 0:
				val=1;
				break;
				
			}
			
		}
	}
	public String getDate() {
		return Date;
	}
	public void setDate(String date) {
		Date = date;
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
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getTotalamt() {
		return totalamt;
	}
	public void setTotalamt(int totalamt) {
		this.totalamt = totalamt;
	}
	
}

