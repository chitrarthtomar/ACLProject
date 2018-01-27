package services;

import java.util.List;

import model.Groups;
import model.User;

public interface GroupService {
	// method to create group
	public boolean createGroup(String gName, String gDescription, String gArbitraryAttributes, String gResource,
			List<User> gUsers);

	// method to update group
	public boolean updateGroup(int gId, String gName, String gDescription, String gArbitraryAttributes,
			String gResource, List<User> gUsers);

	// method to delete group
	public boolean deleteGroup(int gId);

	// method to return one group of given id
	public Groups getById(int gId);

	// method to return all groups
	public List<Groups> getAllGroups();

	// method to get all the users
	public List<User> getAllUsers(int gId);
}
