package model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Resource {
	@Id
	private int rId;
	private String rName;
	private String rPermissions;
	
	public Resource(int rId, String rName, String rPermissions) {
		this.rId = rId;
		this.rName = rName;
		this.rPermissions = rPermissions;
	}
	
	public Resource() {
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
	public String getrPermissions() {
		return rPermissions;
	}
	public void setrPermissions(String rPermissions) {
		this.rPermissions = rPermissions;
	} 
}
