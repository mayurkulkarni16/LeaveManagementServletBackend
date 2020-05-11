package com.hefshine.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.hefshine.bean.Employee;

public class EmpHomeDAO {
	
	public Employee getEmployee(String uname) {
		Employee e = new Employee();
		Connection con = ConnectionProvider.getCon();
		Statement s;
		try {
			s = con.createStatement();
			ResultSet r = s.executeQuery("select * from employee where uname = '"+uname+"'");
			r.next();
			e.setEid(r.getInt(1));
			e.setName(r.getString(2));
			e.setUname(r.getString(3));
			e.setMid(r.getInt(4));
			e.setLeaves(r.getInt(5));
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return e;		
	}

}
