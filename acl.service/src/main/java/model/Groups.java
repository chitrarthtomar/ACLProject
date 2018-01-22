package model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;



@Entity
public class Groups {

	@Id
	private String gId;
	private String gName;
	private String gDescription;
//	private List<User> gUsers;
	private String gArbitraryAttributes;
	private String gResource;
	
	public Groups(String gId, String gName, String gDescription, List<User> gUsers, String gArbitraryAttributes,
			String gResource) {
		this.gId = gId;
		this.gName = gName;
		this.gDescription = gDescription;
//		this.gUsers = gUsers;
		this.gArbitraryAttributes = gArbitraryAttributes;
		this.gResource = gResource;
	}

	public Groups() {
	}

	public String getgId() {
		return gId;
	}
	public void setgId(String gId) {
		this.gId = gId;
	}

//	public List<User> getgUsers() {
//		return gUsers;
//	}
//	public void setgUsers(List<User> gUsers) {
//		this.gUsers = gUsers;
//	}
	public String getgArbitraryAttributes() {
		return gArbitraryAttributes;
	}
	public void setgArbitraryAttributes(String gArbitraryAttributes) {
		this.gArbitraryAttributes = gArbitraryAttributes;
	}
	public String getgResource() {
		return gResource;
	}
	public void setgResource(String gResource) {
		this.gResource = gResource;
	}	
	public String getgName() {
		return gName;
	}
	public void setgName(String gName) {
		this.gName = gName;
	}
	public String getgDescription() {
		return gDescription;
	}
	public void setgDescription(String gDescription) {
		this.gDescription = gDescription;
	}

}
