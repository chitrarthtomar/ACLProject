package services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import model.User;

@Service("userService")
public class UserServiceImpl implements UserService{
	@Autowired
	UserDao userDao; 
	
	
	public void saveUser(User e){  
		return; 
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
