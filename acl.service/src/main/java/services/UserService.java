package services;

import java.util.List;

import org.springframework.orm.hibernate4.HibernateTemplate;

import model.Groups;
import model.User;

public interface UserService {
	
	//method to create user
	public void createUser(String uName, String uPassword, String uMandatoryAttributes, String uArbitraryAttributes, String uResource);  
	//method to update employee  
	public void updateUser(String uId, String name);  
	//method to delete employee  
	public void deleteUser(User e);  
	//method to return one employee of given id  
	public User getById(String id);  
	//method to return all employees  
	public List<User> getAllUsers();  
}
