package com.hefshine.bean;

public class Leaves {
	
	private int leaveno, lid;
	private String status, dfrom, dto, name;
	
	public Leaves() {
		// TODO Auto-generated constructor stub
	}

	public Leaves(int leaveno, String status, String dfrom, String dto, int lid, String name) {
		super();
		this.leaveno = leaveno;
		this.status = status;
		this.dfrom = dfrom;
		this.dto = dto;
		this.lid = lid;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getLid() {
		return lid;
	}

	public void setLid(int lid) {
		this.lid = lid;
	}

	public String getDfrom() {
		return dfrom;
	}

	public void setDfrom(String dfrom) {
		this.dfrom = dfrom;
	}

	public String getDto() {
		return dto;
	}

	public void setDto(String dto) {
		this.dto = dto;
	}

	public int getLeaveno() {
		return leaveno;
	}

	public void setLeaveno(int leaveno) {
		this.leaveno = leaveno;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Leaves [leaveno=" + leaveno + ", lid=" + lid + ", status=" + status + ", dfrom="
				+ dfrom + ", dto=" + dto + ", name=" + name + "]";
	}

}
