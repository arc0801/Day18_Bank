package com.arc.accountInfo;

import java.sql.Date;

public class AccountInfoDTO {

	private int tnum;
	private String anum;
	private Date tdate;
	private long ts;
	private int type; //0-출금, 1-입금
	private long abal;
	
	
	public int getTnum() {
		return tnum;
	}
	public void setTnum(int tnum) {
		this.tnum = tnum;
	}
	public String getAnum() {
		return anum;
	}
	public void setAnum(String anum) {
		this.anum = anum;
	}
	public Date getTdate() {
		return tdate;
	}
	public void setTdate(Date tdate) {
		this.tdate = tdate;
	}
	public long getTs() {
		return ts;
	}
	public void setTs(long ts) {
		this.ts = ts;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public long getAbal() {
		return abal;
	}
	public void setAbal(long abal) {
		this.abal = abal;
	}
	
	
}
