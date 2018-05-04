package com.houseofcards.entities;

import java.util.Set;

import org.json.JSONObject;

public class ReportRequest {
	
	private Set<String> productColumns;
	private Set<String> saleColumns;
	private Set<String> userColumns;
	private Set<String> eventColumns;
	
	private Set<String> chkTables;
	
	
	

	public Set<String> getChkTables() {
		return chkTables;
	}


	public void setChkTables(Set<String> chkTables) {
		this.chkTables = chkTables;
	}
	
	
}
