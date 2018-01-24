package dao;
import java.util.*;

import org.springframework.orm.hibernate4.HibernateTemplate;
import model.User; 

public interface UserDao {
	
	public void setTemplate(HibernateTemplate template);  
	//method to update employee  
	public void updateUser(String uId, String name);  
	//method to delete employee  
	public void deleteUser(User e);  
	//method to return one employee of given id  
	public User getUserById(String id);  
	//method to return all employees  
	public List<User> getAllUsers();  
}
