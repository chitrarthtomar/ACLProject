package services;

import java.util.List;
import model.User;

public interface UserService {

	// return type is void in services and int in dao
	// method to create user
	public boolean createUser(String uName, String uPassword, String uRole, String uMandatoryAttributes,
			String uArbitraryAttributes, String uResource);

	// method to update user
	public boolean updateUser(int uId, String uName, String uPassword, String uRole, String uMandatoryAttributes,
			String uArbitraryAttributes, String uResource);

	// method to delete user
	public boolean deleteUser(int uId);

	// method to return one user of given id
	public User getById(int id);

	// method to return all users
	public List<User> getAllUsers();

	// method to authenticate user
	public User authenticateUser(String name, String password);
}
