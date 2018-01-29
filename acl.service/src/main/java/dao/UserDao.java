package dao;

import java.util.*;
import model.User;

public interface UserDao {
	// method to create user
	public boolean createUser(String uName, String uPassword, String uRole, String uMandatoryAttributes,
			String uArbitraryAttributes, String uResource);

	// method to update user
	public boolean updateUser(int uId, String uName, String uPassword, String uRole, String uMandatoryAttributes,
			String uArbitraryAttributes, String uResource);

	// method to delete user
	public boolean deleteUser(int uId);

	// method to return one user of given id
	public User getUserById(int id);

	// method to return all users
	public List<User> getAllUsers();

	// method to authenticate user
	public User authUser(String name, String password);
}
