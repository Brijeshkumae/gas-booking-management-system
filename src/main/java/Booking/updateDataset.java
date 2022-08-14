package Booking;

import java.sql.Connection;
import java.sql.*;

import com.mysql.cj.xdevapi.Statement;

public class updateDataset {
	public static void getUpdate() throws ClassNotFoundException, SQLException {
		Connection con = Conn.getCon();
		
		String q = "select * FROM purchase";
		java.sql.Statement smt = con.createStatement();
		ResultSet rs = smt.executeQuery(q);
		
		int qu = 0;
		
		
		while(rs.next()) {
			if(rs.getInt("quantity") > 0) {
				qu = rs.getInt("quantity");
			}
		}
		
		//System.out.println(qu);
		
		String query = "update purchase set quantity = ? where slno = 1";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setInt(1, qu-1);
		ps.executeUpdate();
	}

}
