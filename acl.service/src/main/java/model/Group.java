package model;

import java.util.List;

public class Group {
	private String gId;
	private String gName;
	private String gDescription;
	private List<User> gUsers;
	private Object gArbitraryAttributes;
	private Object gResource;
	
	public Group(String gId, String gName, String gDescription, List<User> gUsers, Object gArbitraryAttributes,
			Object gResource) {
		super();
		this.gId = gId;
		this.gName = gName;
		this.gDescription = gDescription;
		this.gUsers = gUsers;
		this.gArbitraryAttributes = gArbitraryAttributes;
		this.gResource = gResource;
	}
	
	public String getgId() {
		return gId;
	}
	public void setgId(String gId) {
		this.gId = gId;
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
	public List<User> getgUsers() {
		return gUsers;
	}
	public void setgUsers(List<User> gUsers) {
		this.gUsers = gUsers;
	}
	public Object getgArbitraryAttributes() {
		return gArbitraryAttributes;
	}
	public void setgArbitraryAttributes(Object gArbitraryAttributes) {
		this.gArbitraryAttributes = gArbitraryAttributes;
	}
	public Object getgResource() {
		return gResource;
	}
	public void setgResource(Object gResource) {
		this.gResource = gResource;
	}

}
