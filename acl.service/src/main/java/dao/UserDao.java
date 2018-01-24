package dao;
import java.util.*;

import org.springframework.orm.hibernate4.HibernateTemplate;

import model.Groups;
import model.User; 

public interface UserDao {
	
//	public void setTemplate(HibernateTemplate template);
	//method to create employee  
	public int createUser(String uName, String uPassword, String uMandatoryAttributes, String uArbitraryAttributes, String uResource);
	//method to update employee  
	public void updateUser(String uId, String name);  
	//method to delete employee  
	public void deleteUser(String uId);  
	//method to return one employee of given id  
	public User getUserById(String id);  
	//method to return all employees  
	public List<User> getAllUsers();  
}
