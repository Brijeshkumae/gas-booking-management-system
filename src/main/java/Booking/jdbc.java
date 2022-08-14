package Booking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;


public class jdbc{
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Hello User Please Enter Your Name: \n");
		String user = br.readLine();
		System.out.println("Welcome To Gas Cylinder Booking Management" + user);
		int val=0;
		while(val==0)
		{
			System.out.println("1-Employee Panel");
			System.out.println("2- Company Purchase Panel");
			System.out.println("3- user Purchase Panel");
			System.out.println("0- Exit");
			int choice =Integer.parseInt(br.readLine());
			switch(choice) {
			case 1: 
				new Employee();
				break;
			case 2:
				new purchase();
				break;
			case 3:
				new userPurchase();
				break;
			case 0:
				val=1;
			}
			
		}
		}
}
