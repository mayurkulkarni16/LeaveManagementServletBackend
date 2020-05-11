package com.hefshine.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.hefshine.bean.Leaves;
import com.hefshine.dao.LeaveStatusDAO;

public class LeaveStatusServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public LeaveStatusServlet() {
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
		String uname = null;
		try {
			JSONObject j = new JSONObject(sb.toString());
			uname = (String) j.get("uname1");
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		LeaveStatusDAO ls = new LeaveStatusDAO();
		List<Leaves> li = ls.getAllLeaves(uname);
		JSONArray ja = new JSONArray();
		JSONObject j;
		for(int i=0;i<li.size();i++)
		{
			j = new JSONObject();
			try {
				j.put("dfrom", li.get(i).getDfrom());
				j.put("dto", li.get(i).getDto());
				j.put("leaveno", li.get(i).getLeaveno());
				j.put("status", li.get(i).getStatus());
				ja.put(j);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		PrintWriter pw = response.getWriter();
		pw.write(ja.toString());
		System.out.println(ja.toString());
	}

}
