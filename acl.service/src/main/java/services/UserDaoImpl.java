package services;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import model.User;

@Repository
@Transactional
public class UserDaoImpl implements UserDao{
	
	
	@Autowired
    private static SessionFactory sessionFactory;
	private ServiceRegistry serviceRegistry;

	public static SessionFactory createSessionFactory() {
	    Configuration configuration = new Configuration();
	    configuration.configure();
	    ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(
	            configuration.getProperties()). buildServiceRegistry();
	    sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	    return sessionFactory;
	}
	
	
	//method to update employee  
	public void updateUser(String uId, String name){ 
	      
				  SessionFactory sf = createSessionFactory();
				  Session sess = sf.openSession();
				  try {
					    sess.getTransaction().begin();

					    User user = (User)sess.get(User.class, uId); 
				        user.setuName(name);
				        sess.update(user);
					    sess.getTransaction().commit();
					}
					catch (RuntimeException e) {
					    sess.getTransaction().rollback();
					    throw e;
					}
	}  
	//method to delete employee  
	public void deleteUser(User e){   
	}  
	//method to return one employee of given id  
	public User getById(String id){
		return null;   
	}  
	//method to return all employees  
	public List<User> getAllUsers(){  
	    return null ;
	}  
	private Session getSession() {
        Session sess = getSessionFactory().getCurrentSession();
        if (sess == null) {
               sess = getSessionFactory().openSession();
        }
        return sess;
	}

 private SessionFactory getSessionFactory() {
        return sessionFactory;
 }
public void setTemplate(HibernateTemplate template) {
	// TODO Auto-generated method stub
	
}
public User getUserById(String id) {
	// TODO Auto-generated method stub
	return null;
}
}
