package services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.UserDao;
import model.User;

@Service("userService")
public class UserServiceImpl implements UserService {
	@Autowired
	UserDao userDao;

	// create user
	public boolean createUser(String uName, String uPassword, String uRole, String uMandatoryAttributes,
			String uArbitraryAttributes, String uResource) {
		return userDao.createUser(uName, uPassword, uRole, uMandatoryAttributes, uArbitraryAttributes, uResource);
	}

	@Override
	// method to update employee
	public boolean updateUser(int uId, String uName, String uPassword, String uRole, String uMandatoryAttributes,
			String uArbitraryAttributes, String uResource) {
		return userDao.updateUser(uId, uName, uPassword, uRole, uMandatoryAttributes, uArbitraryAttributes, uResource);
	}

	// method to delete employee
	@Override
	public boolean deleteUser(int uId) {
		return userDao.deleteUser(uId);
	}

	// method to return one employee of given id
	@Override
	public List<User> getAllUsers() {
		return userDao.getAllUsers();
	}

	@Override
	public User getById(int id) {
		return userDao.getUserById(id);
	}

	@Override
	public User authenticateUser(String name, String password) {
		return userDao.authUser(name, password);
	}
}
