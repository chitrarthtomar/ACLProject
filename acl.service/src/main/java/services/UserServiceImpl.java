package services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Service;

import model.User;

@Service
public class UserServiceImpl {
	@Autowired
	UserDao userDao; 
	
	public void setTemplate(HibernateTemplate template) {  
	    return; 
	}
	public void saveUser(User e){  
		return; 
	}  
	//method to update employee  
	public void updateUser(User e){  
		return;   
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
