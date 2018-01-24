package model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.JoinColumn;


@Entity
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int uId;
//	@ManyToMany(mappedBy="gUsers")
//	private List<Groups> uGroups;
	private String uName;
	private String uPassword;
	private String uMandatoryAttributes;
	private String uArbitraryAttributes;
	private String uResource;
	public User(){
	}
	
	public User(String uName, String uPassword, String uMandatoryAttributes,
			String uArbitraryAttributes, String uResource) {
		super();
		this.uName = uName;
		this.uPassword = uPassword;
		this.uMandatoryAttributes = uMandatoryAttributes;
		this.uArbitraryAttributes = uArbitraryAttributes;
		this.uResource = uResource;
	}

//	public List<Groups> getuGroups() {
//		return uGroups;
//	}
//
//	public void setuGroups(List<Groups> uGroups) {
//		this.uGroups = uGroups;
//	}
	public int getuId() {
		return uId;
	}
	public void setuId(int uId) {
		this.uId = uId;
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
	public String getuResource() {
		return uResource;
	}
}
