package com.hefshine.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginDAO {
	
	public String ifExist(String uname, String pass) {
		int cnt = 0;
		String desig = null;
		boolean flag = false;
		Connection con = ConnectionProvider.getCon();
		try {
			Statement s = con.createStatement();
			ResultSet r = s.executeQuery("select * from employee where uname = '"+uname+"' and password = '"+pass+"'");
			while(r.next())
			{
				cnt = r.getInt(4);
				flag = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(cnt == 0 && flag == true)
			desig = "manager";
		else if(flag == true)
			desig = "employee";
		else
			desig = "wrong";
		return desig;
	}

}
