package model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.JoinColumn;



@Entity
public class User {
	@Id
	private String uId;
	private String uName;
	private String uPassword;
	/**
	 * 
	 */
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="USER_GROUP",joinColumns= {@JoinColumn(name="USER_ID")},inverseJoinColumns= {@JoinColumn(name="GROUP_ID")})
	private List<Groups> uGroups;
	private String uMandatoryAttributes;
	private String uArbitraryAttributes;
	private String uResource;
	
	public User(){
	}
	
	public User(String uId, String uName, String uPassword, List<Groups> uGroups, String uMandatoryAttributes,
			String uArbitraryAttributes, String uResource) {
		super();
		this.uId = uId;
		this.uName = uName;
		this.uPassword = uPassword;
		this.uGroups = uGroups;
		this.uMandatoryAttributes = uMandatoryAttributes;
		this.uArbitraryAttributes = uArbitraryAttributes;
		this.uResource = uResource;
	}

	
	public String getuId() {
		return uId;
	}
	public void setuId(String uId) {
		this.uId = uId;
	}
	
	
	public List<Groups> getuGroups() {
		return uGroups;
	}
	public void setuGroups(List<Groups> uGroups) {
		this.uGroups = uGroups;
	}
	
	public String getuMandatoryAttributes() {
		return uMandatoryAttributes;
	}
	public void setuMandatoryAttributes(String uMandatoryAttributes) {
		this.uMandatoryAttributes = uMandatoryAttributes;
	}
	public String getuArbitraryAttributes() {
		return uArbitraryAttributes;
	}
	public void setuArbitraryAttributes(String uArbitraryAttributes) {
		this.uArbitraryAttributes = uArbitraryAttributes;
	}
	public void setuResource(String uResource) {
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
