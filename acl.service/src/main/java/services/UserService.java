package services;

import java.util.List;

import org.springframework.orm.hibernate4.HibernateTemplate;

import model.User;

public interface UserService {
	public void setTemplate(HibernateTemplate template);
	public void saveUser(User e);  
	//method to update employee  
	public void updateUser(User e);  
	//method to delete employee  
	public void deleteUser(User e);  
	//method to return one employee of given id  
	public User getById(String id);  
	//method to return all employees  
	public List<User> getAllUsers();  
}
