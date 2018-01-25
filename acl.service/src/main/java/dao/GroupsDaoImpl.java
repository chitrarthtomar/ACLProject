package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import model.Groups;
import model.User;

@Transactional
@Repository
public class GroupsDaoImpl implements GroupsDao{
	
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

	@Override
	public int createGroup(String gName, String gDescription, String gArbitraryAttributes, String gResource) {
		SessionFactory sf = createSessionFactory();
		Session sess = sf.openSession();
		int gId=-1; // review this later
		 try {
			 sess.getTransaction().begin();
			 Groups group = new Groups(gName,gDescription,gArbitraryAttributes, gResource);
			 gId= (Integer)sess.save(group);
			 sess.getTransaction().commit();
		 }
		 catch (RuntimeException e) {
			 sess.getTransaction().rollback();
			 throw e;
		 }
		 return gId;
	}

	@Override
	public void updateGroup(int gId, String gName, String gDescription, String gArbitraryAttributes, String gResource) {
		SessionFactory sf = createSessionFactory();
		 Session sess = sf.openSession();
		 try {
			 sess.getTransaction().begin(); 
		     if(!this.deleteGroup(gId)) {
		    	 return;
		     }
		     this.createGroup(gName,gDescription,gArbitraryAttributes, gResource);
			 sess.getTransaction().commit();
		 }
		 catch (RuntimeException e) {
			 sess.getTransaction().rollback();
			 throw e;
		 }
	}

	@Override
	public boolean deleteGroup(int gId) {
		SessionFactory sf = createSessionFactory();
		 Session sess = sf.openSession();
		 try {
			 sess.getTransaction().begin();
			 Groups group = (Groups)sess.get(Groups.class, gId);
			 if(group==null) {
				 return false; // if user is not present do nothing
			 }
		     sess.delete(group);
			 sess.getTransaction().commit();
		 }
		 catch (RuntimeException e) {
			 sess.getTransaction().rollback();
			 throw e;
		 }
		 return true;
	}

	@Override
	public Groups getById(int gId) {
		SessionFactory sf = createSessionFactory();
		Session sess = sf.openSession();
		Groups group;
		 try {
			 sess.getTransaction().begin();
			 group = (Groups)sess.get(Groups.class, gId);
			 sess.getTransaction().commit();
		 }
		 catch (RuntimeException e) {
			 sess.getTransaction().rollback();
			 throw e;
		 }
	    return group;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Groups> getAllGroups() {
		SessionFactory sf = createSessionFactory();
		Session sess = sf.openSession();
		List<Groups> list =null;
		 try {
			 sess.getTransaction().begin();
			 list = sess.createCriteria(Groups.class).list();
			 sess.getTransaction().commit();
		 }
		 catch (RuntimeException e) {
			 sess.getTransaction().rollback();
			 throw e;
		 }
	    return list;
	}

	@Override
	public List<User> getAllUsers(int gId) {
		SessionFactory sf = createSessionFactory();
		Session sess = sf.openSession();
		List<User> list =null;
		 try {
			 sess.getTransaction().begin();
			 Groups group = (Groups)sess.get(Groups.class, gId);
			 if(group != null)
				 list = group.getgUsers();
			 sess.getTransaction().commit();
		 }
		 catch (RuntimeException e) {
			 sess.getTransaction().rollback();
			 throw e;
		 }
	    return list;
	}
}
