package model;

import java.util.List;

public class Resource {
	private int rId;
	private String rName;
	private List<String> rPermissions;
	public Resource(int rId, String rName, List<String> rPermissions) {
		this.rId = rId;
		this.rName = rName;
		this.rPermissions = rPermissions;
	}
	public int getrId() {
		return rId;
	}
	public void setrId(int rId) {
		this.rId = rId;
	}
	public String getrName() {
		return rName;
	}
	public void setrName(String rName) {
		this.rName = rName;
	}
	public List<String> getrPermissions() {
		return rPermissions;
	}
	public void setrPermissions(List<String> rPermissions) {
		this.rPermissions = rPermissions;
	} 
}
