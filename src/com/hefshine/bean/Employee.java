package com.hefshine.bean;

public class Employee {
	
	private String uname, name;
	private int eid, mid, leaves;
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public Employee(String uname, String name, int eid, int mid, int leaves) {
		super();
		this.uname = uname;
		this.name = name;
		this.eid = eid;
		this.mid = mid;
		this.leaves = leaves;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public int getMid() {
		return mid;
	}

	public void setMid(int mid) {
		this.mid = mid;
	}

	public int getLeaves() {
		return leaves;
	}

	public void setLeaves(int leaves) {
		this.leaves = leaves;
	}

	@Override
	public String toString() {
		return "Employee [uname=" + uname + ", name=" + name + ", eid=" + eid + ", mid=" + mid + ", leaves=" + leaves
				+ "]";
	}

}
