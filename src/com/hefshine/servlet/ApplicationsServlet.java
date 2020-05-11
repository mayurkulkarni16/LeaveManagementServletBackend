package com.hefshine.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.hefshine.bean.Leaves;
import com.hefshine.dao.ApplicationDAO;

public class ApplicationsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ApplicationsServlet() {
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
		try {
			JSONObject j = new JSONObject(sb.toString());
			uname = j.getString("uname1");
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ArrayList<Leaves> li = ApplicationDAO.getLeaves(uname);
		JSONArray ja = new JSONArray();
		JSONObject j;
		for(int i=0;i<li.size();i++)
		{
			j = new JSONObject();
			try {
				j.put("lid", li.get(i).getLid());
				j.put("name", li.get(i).getName());
				j.put("dfrom", li.get(i).getDfrom());
				j.put("dto", li.get(i).getDto());
				j.put("leaveno", li.get(i).getLeaveno());
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//			System.out.println(j);
			ja.put(j);
		}
		PrintWriter pw = response.getWriter();
		pw.write(ja.toString());
//		System.out.println(ja);
	}

}
