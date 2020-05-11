package com.hefshine.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.hefshine.bean.Leaves;

public class LeaveStatusDAO {
	
	public List<Leaves> getAllLeaves(String uname) {
		List<Leaves> li = new ArrayList<>();
		Leaves l;
		Connection con = ConnectionProvider.getCon();
		try {
			Statement s = con.createStatement();
			ResultSet r = s.executeQuery("select * from leaves where eid = (select eid from employee where uname = '"+uname+"')");
			while(r.next())
			{
				l = new Leaves();
				l.setDfrom(r.getString(3));
				l.setDto(r.getString(4));
				l.setLeaveno(r.getInt(5));
				l.setStatus(r.getString(6));
				li.add(l);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return li;
	}

}
