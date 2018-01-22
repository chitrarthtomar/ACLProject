package model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.JoinColumn;

import org.json.JSONArray;

@Entity
public class User {
	private String uId;
	private String uName;
	private String uPassword;
	private List<Group> uGroups;
	private JSONArray uMandatoryAttributes;
	private JSONArray uArbitraryAttributes;
	private JSONArray uResource;
	
	public User(){
	}
	
	public User(String uId, String uName, String uPassword, List<Group> uGroups, JSONArray uMandatoryAttributes,
			JSONArray uArbitraryAttributes, JSONArray uResource) {
		super();
		this.uId = uId;
		this.uName = uName;
		this.uPassword = uPassword;
		this.uGroups = uGroups;
		this.uMandatoryAttributes = uMandatoryAttributes;
		this.uArbitraryAttributes = uArbitraryAttributes;
		this.uResource = uResource;
	}

	@Id
	public String getuId() {
		return uId;
	}
	public void setuId(String uId) {
		this.uId = uId;
	}
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="USER_GROUP",joinColumns= {@JoinColumn(name="USER_ID")},inverseJoinColumns= {@JoinColumn(name="GROUP_ID")})
	public List<Group> getuGroups() {
		return uGroups;
	}
	public void setuGroups(List<Group> uGroups) {
		this.uGroups = uGroups;
	}
	
	public JSONArray getuMandatoryAttributes() {
		return uMandatoryAttributes;
	}
	public void setuMandatoryAttributes(JSONArray uMandatoryAttributes) {
		this.uMandatoryAttributes = uMandatoryAttributes;
	}
	public JSONArray getuArbitraryAttributes() {
		return uArbitraryAttributes;
	}
	public void setuArbitraryAttributes(JSONArray uArbitraryAttributes) {
		this.uArbitraryAttributes = uArbitraryAttributes;
	}
	public void setuResource(JSONArray uResource) {
		this.uResource = uResource;
	}
	public String getuName() {
		return uName;
	}
	public void setuName(String uName) {
		this.uName = uName;
	}

	public String getuPassword() {
		return uPassword;
	}
	public void setuPassword(String uPassword) {
		this.uPassword = uPassword;
	}
	public Object getuResource() {
		return uResource;
	}

}
