package dto;
import java.util.List;

import model.Groups;
import model.User;

public class GroupDto {
	Groups group;
	List<User> otherUsers;
	public List<User> getOtherUsers() {
		return otherUsers;
	}
	public void setOtherUsers(List<User> otherUsers) {
		this.otherUsers = otherUsers;
	}
	public Groups getGroup() {
		return group;
	}
	public void setGroup(Groups group) {
		this.group = group;
	}
}