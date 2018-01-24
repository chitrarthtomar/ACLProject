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
	public void createUser(String uName, String uPassword, String uMandatoryAttributes, String uArbitraryAttributes, String uResource){  
		System.out.println("creating ");
		userDao.createUser(uName, uPassword, uMandatoryAttributes, uArbitraryAttributes, uResource);
	}  
	//method to update employee 
	
	public void updateUser(String uId, String name){
		System.out.println("service update");
		userDao.updateUser(uId, name);   
	}  
	//method to delete employee 
	public void deleteUser(User e){  
		return;  
	}  
	//method to return one employee of given id 
	
	public User getById(String id){  
		return null;   
	}  
	//method to return all employees
	
	public List<User> getAllUsers(){  
		return null;   
	}
}
