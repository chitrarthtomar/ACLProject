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
public class Groups {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int gId;
	private String gName;
	private String gDescription;
	private String gArbitraryAttributes;
	private String gResource;
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="GROUP_USER",joinColumns= {@JoinColumn(name="GROUP_ID")}, inverseJoinColumns= {@JoinColumn(name="USER_ID")})
	private List<User> gUsers;
	
	public List<User> getgUsers() {
		return gUsers;
	}

	public void setgUsers(List<User> gUsers) {
		this.gUsers = gUsers;
	}

	public Groups(String gName, String gDescription, String gArbitraryAttributes, String gResource) {
		this.gName = gName;
		this.gDescription = gDescription;
		this.gArbitraryAttributes = gArbitraryAttributes;
		this.gResource = gResource;
	}

	public Groups() {
	}

	public int getgId() {
		return gId;
	}
	public void setgId(int gId) {
		this.gId = gId;
	}
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
