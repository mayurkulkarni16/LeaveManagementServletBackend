package com.hefshine.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONException;
import org.json.JSONObject;

import com.hefshine.dao.LoginDAO;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String desig = "";
		StringBuilder sb = new StringBuilder();
		BufferedReader br = request.getReader();
		String s = null;
		while((s = br.readLine()) != null)
		{
			sb.append(s);
		}
		String uname = "", pass = "";
		try {
			JSONObject j1 = new JSONObject(sb.toString());
			System.out.println(j1.toString());
			uname = j1.getString("uname1");
			pass = j1.getString("pass1");
		} catch (JSONException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
//		System.out.println(uname);
//		System.out.println(pass);
		
		LoginDAO ld = new LoginDAO();
		desig = ld.ifExist(uname, pass);
		
		JSONObject j = new JSONObject();
		try {
			j.put("desig", desig);
			j.put("uname", uname);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PrintWriter pw = response.getWriter();
		pw.write(j.toString());
		System.out.println(j.toString());
	}

}
