package services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.UserDao;
import model.Groups;
import model.User;

@Service("userService")
public class UserServiceImpl implements UserService{
	@Autowired
	UserDao userDao; 
	
	//create user
	public void createUser(String uName, String uPassword,  String uRole, String uMandatoryAttributes, String uArbitraryAttributes, String uResource){  
		userDao.createUser(uName, uPassword, uRole, uMandatoryAttributes, uArbitraryAttributes, uResource);
	}  
	
	@Override
	//method to update employee 
	public void updateUser(int uId, String uName, String uPassword,  String uRole, String uMandatoryAttributes, String uArbitraryAttributes, String uResource){
		userDao.updateUser(uId, uName, uPassword, uRole, uMandatoryAttributes, uArbitraryAttributes, uResource);   
	}  
	
	//method to delete employee
	@Override
	public boolean deleteUser(int uId){  
		return userDao.deleteUser(uId);
	}  
	//method to return one employee of given id 
	@Override
	public List<User> getAllUsers(){  
		return userDao.getAllUsers();   
	}

	@Override
	public User getById(int id) {
		return userDao.getUserById(id);
	}
}
