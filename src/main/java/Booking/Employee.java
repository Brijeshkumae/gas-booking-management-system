package Booking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Employee {
	
	 String name;
	 String Email;
	 String password;
	public Employee(String Email,String name,String password) {
		super();
		this.name=name;
		this.Email=Email;
		this.password=password;
		}
	public Employee() throws NumberFormatException, IOException, ClassNotFoundException, SQLException
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int val=0;
		while(val==0) {
			System.out.println("1- Employee Details Insertion");
			System.out.println("2- Employee Details Deleted");
			System.out.println("3- Show Employee Details");
			System.out.println("4- Update Details");
			System.out.println("0- Exit");
			int choice=Integer.parseInt(br.readLine());
			switch(choice) {
			case 1:
				System.out.println("Enter name");
				String name=br.readLine();
				System.out.println("Enter email");
				String email=br.readLine();
				System.out.println("Enter password");
				String password=br.readLine();
				Employee em=new Employee(email,name,password);
				EmployeeDao.insert(em);
			break;
			case 2:
				System.out.println("Enter name");
				String name1=br.readLine();
				EmployeeDao.delete(name1);
				break;	
			case 3:
				EmployeeDao.showData();
				break;
			case 4:
				System.out.println("Enter Choice");
				System.out.println("1- Update Name");
				System.out.println("2- Update Email");
				System.out.println("3- Update Password");
				int value=Integer.parseInt(br.readLine());
				System.out.println("Enter The value to be updated");
				String update=br.readLine();
				System.out.println("Enter the serial number");
				int slno=Integer.parseInt(br.readLine());
				EmployeeDao.updateRecord(value, update, slno);
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
	public String getEmail() {
		return Email;
	}
	public void setEmail(String Email) {
		this.Email = Email;
	}
	public String getPassword() {
		return password; 
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
	


