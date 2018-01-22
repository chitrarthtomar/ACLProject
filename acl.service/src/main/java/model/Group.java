package model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.json.JSONArray;

@Entity
public class Group {
	private String gId;
	private String gName;
	private String gDescription;
	private List<User> gUsers;
	private JSONArray gArbitraryAttributes;
	private JSONArray gResource;
	
	public Group(String gId, String gName, String gDescription, List<User> gUsers, JSONArray gArbitraryAttributes,
			JSONArray gResource) {
		this.gId = gId;
		this.gName = gName;
		this.gDescription = gDescription;
		this.gUsers = gUsers;
		this.gArbitraryAttributes = gArbitraryAttributes;
		this.gResource = gResource;
	}

	@Id
	public String getgId() {
		return gId;
	}
	public void setgId(String gId) {
		this.gId = gId;
	}

	public List<User> getgUsers() {
		return gUsers;
	}
	public void setgUsers(List<User> gUsers) {
		this.gUsers = gUsers;
	}
	public JSONArray getgArbitraryAttributes() {
		return gArbitraryAttributes;
	}
	public void setgArbitraryAttributes(JSONArray gArbitraryAttributes) {
		this.gArbitraryAttributes = gArbitraryAttributes;
	}
	public JSONArray getgResource() {
		return gResource;
	}
	public void setgResource(JSONArray gResource) {
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
