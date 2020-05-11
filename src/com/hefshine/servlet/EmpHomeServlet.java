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

import com.hefshine.bean.Employee;
import com.hefshine.dao.EmpHomeDAO;

public class EmpHomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public EmpHomeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = request.getReader();
		String s = null;
		
		while((s=br.readLine())!=null)
			sb.append(s);
		
		String uname = "";
		try {
			JSONObject j = new JSONObject(sb.toString());
			uname = j.getString("uname1");
			System.out.println(uname);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		EmpHomeDAO ed = new EmpHomeDAO();
		Employee e = ed.getEmployee(uname);
		JSONObject j1 = new JSONObject();
		try {
			j1.put("eid", e.getEid());
			j1.put("name", e.getName());
			j1.put("uname", e.getUname());
			j1.put("mid", e.getMid());
			j1.put("leaves", e.getLeaves());
		} catch (JSONException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		PrintWriter pw = response.getWriter();
		pw.write(j1.toString());
	}

}
