package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
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

import dao.UserDao;
import model.Groups;
import model.User;

@Repository
@Transactional
public class UserDaoImpl implements UserDao{
	
	
	@Autowired
    private static SessionFactory sessionFactory;
	public static SessionFactory createSessionFactory() {
	    Configuration configuration = new Configuration();
	    configuration.configure();
	    ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(
	            configuration.getProperties()). buildServiceRegistry();
	    sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	    return sessionFactory;
	}
	//method to create user
	public int createUser(String uName, String uPassword, String uRole, String uMandatoryAttributes, String uArbitraryAttributes, String uResource){
		SessionFactory sf = createSessionFactory();
		Session sess = sf.openSession();
		int uId=-1; // review this later
		 try {
			 sess.getTransaction().begin();
			 User user = new User(uName,uPassword, uRole, uMandatoryAttributes, uArbitraryAttributes, uResource);
			 uId= (Integer)sess.save(user);
			 sess.getTransaction().commit();
		 }
		 catch (RuntimeException e) {
			 sess.getTransaction().rollback();
			 throw e;
		 }
		 return uId;
	}  
	
	//method to update employee  
	public void updateUser(int uId, String uName, String uPassword,  String uRole, String uMandatoryAttributes, String uArbitraryAttributes, String uResource){ 
		 SessionFactory sf = createSessionFactory();
		 Session sess = sf.openSession();
		 try {
			 sess.getTransaction().begin(); 
		     if(!this.deleteUser(uId)) {
		    	 return;
		     }
		     this.createUser(uName, uPassword, uRole, uMandatoryAttributes, uArbitraryAttributes, uResource);
			 sess.getTransaction().commit();
		 }
		 catch (RuntimeException e) {
			 sess.getTransaction().rollback();
			 throw e;
		 }
	}  
	//method to delete employee  
	public boolean deleteUser(int uId){
		SessionFactory sf = createSessionFactory();
		 Session sess = sf.openSession();
		 try {
			 sess.getTransaction().begin();
			 User user = (User)sess.get(User.class, uId);
			 if(user==null) {
				 return false; // if user is not present do nothing
			 }
		     sess.delete(user);
			 sess.getTransaction().commit();
		 }
		 catch (RuntimeException e) {
			 sess.getTransaction().rollback();
			 throw e;
		 }
		 return true;
	}  

	//method to return all employees  
	@SuppressWarnings("unchecked")
	public List<User> getAllUsers(){
		SessionFactory sf = createSessionFactory();
		Session sess = sf.openSession();
		List<User> list =null;
		 try {
			 sess.getTransaction().begin();
			 list = sess.createCriteria(User.class).list();
			 sess.getTransaction().commit();
		 }
		 catch (RuntimeException e) {
			 sess.getTransaction().rollback();
			 throw e;
		 }
	    return list;
	}
	//method to return one employee of given id
	public User getUserById(int uId) {
		SessionFactory sf = createSessionFactory();
		Session sess = sf.openSession();
		User user;
		 try {
			 sess.getTransaction().begin();
			 user = (User)sess.get(User.class, uId);
			 sess.getTransaction().commit();
		 }
		 catch (RuntimeException e) {
			 sess.getTransaction().rollback();
			 throw e;
		 }
	    return user;
	}
	@Override
	public User authUser(String name, String password) {
		SessionFactory sf = createSessionFactory();
		Session sess = sf.openSession();
		User user = null;
		 try {
			 sess.getTransaction().begin();
			 String hql = "From User where uName='"+name+"' AND uPassword = '"+password+"'";
			 Query query = sess.createQuery(hql);
			 List list = query.list();
			 if(!list.isEmpty())
				 user = (User) list.get(0);
			 sess.getTransaction().commit();
		 }
		 catch (RuntimeException e) {
			 sess.getTransaction().rollback();
			 throw e;
		 }
	    return user;
	}
}
