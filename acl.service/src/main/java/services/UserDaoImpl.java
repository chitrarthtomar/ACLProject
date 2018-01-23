package services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import model.User;

@Repository
@Transactional
public class UserDaoImpl {
	
	@Autowired
	HibernateTemplate template; 
	
	public void setTemplate(HibernateTemplate template) {  
	    this.template = template;  
	}
	public void saveUser(User e){  
	    template.save(e);  
	}  
	//method to update employee  
	public void updateUser(User e){  
	    template.update(e);  
	}  
	//method to delete employee  
	public void deleteUser(User e){  
	    template.delete(e);  
	}  
	//method to return one employee of given id  
	public User getById(String id){  
	    return template.get(User.class,id);  
	}  
	//method to return all employees  
	public List<User> getAllUsers(){  
	    return template.loadAll(User.class);  
	}  
}
