package services;

import java.util.List;

import org.springframework.orm.hibernate4.HibernateTemplate;

import model.Groups;
import model.User;

public interface UserService {
	
	
	//return type is void in services and int in dao
	//method to create user
	public void createUser(String uName, String uPassword,  String uRole, String uMandatoryAttributes, String uArbitraryAttributes, String uResource);  
	//method to update user  
	public void updateUser(int uId, String uName, String uPassword, String uRole, String uMandatoryAttributes, String uArbitraryAttributes, String uResource);  
	//method to delete user  
	public boolean deleteUser(int uId);  
	//method to return one user of given id  
	public User getById(int id);  
	//method to return all users  
	public List<User> getAllUsers(); 
	
	public User authenticateUser(String name,String password);
}
