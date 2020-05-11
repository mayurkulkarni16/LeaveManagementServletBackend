package com.hefshine.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LeaveApplicationDAO {
	
	public int leaveActopn(String action, int lid) {
		int result = 0;
		Connection con = ConnectionProvider.getCon();
		try {
			String sql = "UPDATE `leaves` SET `status`= ? WHERE lid = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, action);
			ps.setInt(2, lid);
			result = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

}
