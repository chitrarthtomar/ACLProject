package dao;
import java.util.*;
import model.User; 

public interface UserDao {
	
//	public void setTemplate(HibernateTemplate template);
	//method to create user  
	public int createUser(String uName, String uPassword,  String uRole, String uMandatoryAttributes, String uArbitraryAttributes, String uResource);
	//method to update user  
	public void updateUser(int uId, String uName, String uPassword,  String uRole, String uMandatoryAttributes, String uArbitraryAttributes, String uResource);  
	//method to delete user  
	public boolean deleteUser(int uId);  
	//method to return one user of given id  
	public User getUserById(int id);  
	//method to return all users  
	public List<User> getAllUsers();  
}
