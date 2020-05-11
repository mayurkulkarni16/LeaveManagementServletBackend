package com.hefshine.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import com.hefshine.dao.leaveApplyDAO;

public class leaveApplyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public leaveApplyServlet() {
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
		{
			sb.append(s);
		}
		String uname = null;
		Date d1 = null, d2 = null;
		int days = 0;
		JSONObject j = null;
		try {
			j = new JSONObject(sb.toString());
//			System.out.println(j);
			uname = j.getString("uname");
			d1 = new SimpleDateFormat("yyyy-MM-dd").parse(j.getString("dfrom"));
//			System.out.println(d1);
			d2 = new SimpleDateFormat("yyyy-MM-dd").parse(j.getString("dto"));
//			System.out.println(d2);
			days = (int) ((d2.getTime()-d1.getTime()) / (24 * 60 * 60 * 1000));
		} catch (JSONException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		System.out.println(j);
		leaveApplyDAO la = new leaveApplyDAO();
		int result=0;
		if(d1.compareTo(d2)>0)
			result = -1;
		else
		{
//			System.out.println(days+"days");
			try {
				result = la.applyLeave(days, uname, j.getString("dfrom"), j.getString("dto"));
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		JSONObject j2 = new JSONObject();
		try {
			j2.put("result", result);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PrintWriter pw = response.getWriter();
		pw.write(j2.toString());
	}

}
