package model;

import java.util.List;

public class User {
	private String uId;
	private String uName;
	private String uPassword;
	private List<Group> uGroups;
	private Object uMandatoryAttributes;
	private Object uArbitraryAttributes;
	private Object uResource;

	public User(String uId, String uName,String uPassword, List<Group> uGroups, String uMandatoryAttributes, String uArbitraryAttributes,List<Object> uResource) {
		this.uId = uId;
		this.uName = uName;
		this.uGroups = uGroups;
		this.uMandatoryAttributes = uMandatoryAttributes;
		this.uArbitraryAttributes = uArbitraryAttributes;
		this.uPassword = uPassword;
		this.uResource = uResource;
	}

	public String getuId() {
		return uId;
	}
	public void setuId(String uId) {
		this.uId = uId;
	}
	public String getuName() {
		return uName;
	}
	public void setuName(String uName) {
		this.uName = uName;
	}
	public List<Group> getuGroups() {
		return uGroups;
	}
	public void setuGroups(List<Group> uGroups) {
		this.uGroups = uGroups;
	}
	public Object getuMandatoryAttributes() {
		return uMandatoryAttributes;
	}
	public void setuMandatoryAttributes(String uMandatoryAttributes) {
		this.uMandatoryAttributes = uMandatoryAttributes;
	}
	public Object getuArbitraryAttributes() {
		return uArbitraryAttributes;
	}
	public void setuArbitraryAttributes(String uArbitraryAttributes) {
		this.uArbitraryAttributes = uArbitraryAttributes;
	}
	public String getuPassword() {
		return uPassword;
	}
	public void setuPassword(String uPassword) {
		this.uPassword = uPassword;
	}
	public List<Object> getuResource() {
		return uResource;
	}
	public void setuResource(List<Object> uResource) {
		this.uResource = uResource;
	}
}
