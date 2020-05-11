package com.hefshine.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.hefshine.bean.Leaves;

public class ApplicationDAO {
	
	public static ArrayList<Leaves> getLeaves(String uname){
		ArrayList<Leaves> li = new ArrayList<>();
		Leaves l;
		int mid;
		Connection con = ConnectionProvider.getCon();
		try {
			Statement s = con.createStatement();
			ResultSet r = s.executeQuery("select lid, name, from_date, to_date, total_leave from employee e, leaves l where e.eid=l.eid and mid = (select eid from employee where uname = '"+uname+"' and status = 'p')");
			while(r.next())
			{
				l = new Leaves();
				l.setLid(r.getInt(1));
				l.setName(r.getString(2));
				l.setDfrom(r.getString(3));
				l.setDto(r.getString(4));
				l.setLeaveno(r.getInt(5));
				li.add(l);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return li;
	}

}
