package com.hefshine.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import com.hefshine.dao.LeaveApplicationDAO;

public class LeaveActionsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public LeaveActionsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = request.getReader();
		String s = null;
		while((s=br.readLine())!=null) {
			sb.append(s);
		}
		String actions = null;
		int lid = 0;
		try {
			JSONObject j = new JSONObject(sb.toString());
			System.out.println(j);
			actions = j.getString("action");
			lid = j.getInt("lid");
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		LeaveApplicationDAO ld = new LeaveApplicationDAO();
		int result = ld.leaveActopn(actions, lid);
		JSONObject j = new JSONObject();
		try {
			j.put("data", result);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PrintWriter pw = response.getWriter();
		pw.write(j.toString());
		System.out.println(j.toString());
	}

}
