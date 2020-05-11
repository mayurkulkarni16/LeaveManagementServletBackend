package com.hefshine.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class leaveApplyDAO {
	
	public int applyLeave(int days, String uname, String fromdate, String todate) {
		Connection con = ConnectionProvider.getCon();
		Statement s;
		ResultSet r;
		int bal=0, eid, a = 0;
		try {
			s = con.createStatement();
			r = s.executeQuery("select leaves, eid from employee where uname = '"+uname+"'");
			r.next();
			bal = r.getInt(1);
			eid = r.getInt(2);
			System.out.println(bal);
			if(days <= bal)
			{
				PreparedStatement ps = con.prepareStatement("INSERT INTO `leaves`(`eid`, `from_date`, `to_date`, `total_leave`, `status`) VALUES (?,?,?,?,?)");
				ps.setInt(1, eid);
				ps.setString(2, fromdate);
				ps.setString(3, todate);
				ps.setInt(4, days);
				ps.setString(5, "p");
				a=ps.executeUpdate();
				ps = con.prepareStatement("UPDATE `employee` SET `leaves`= ? WHERE uname = ?");
				ps.setInt(1, bal-days);
				ps.setString(2, uname);
				ps.executeUpdate();
			}
			else
				a = 2;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return a;
	}

}
