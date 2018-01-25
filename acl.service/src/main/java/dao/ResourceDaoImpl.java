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

import model.Resource;
import model.User;

@Transactional
@Repository
public class ResourceDaoImpl implements ResourceDao{
	
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
	public int createResource(String rName, String rPermissions) {
		SessionFactory sf = createSessionFactory();
		Session sess = sf.openSession();
		int rId=-1; // review this later
		 try {
			 sess.getTransaction().begin();
			 Resource resource = new Resource(rName,rPermissions);
			 rId= (Integer)sess.save(resource);
			 sess.getTransaction().commit();
		 }
		 catch (RuntimeException e) {
			 sess.getTransaction().rollback();
			 throw e;
		 }
		 return rId;
	}

	@Override
	public void updateResource(int rId, String rName, String rPermissions) {
		SessionFactory sf = createSessionFactory();
		 Session sess = sf.openSession();
		 try {
			 sess.getTransaction().begin(); 
		     if(!this.deleteResource(rId)) {
		    	 return;
		     }
		     this.createResource(rName, rPermissions);
			 sess.getTransaction().commit();
		 }
		 catch (RuntimeException e) {
			 sess.getTransaction().rollback();
			 throw e;
		 }
		
	}

	@Override
	public boolean deleteResource(int rId) {
		SessionFactory sf = createSessionFactory();
		 Session sess = sf.openSession();
		 try {
			 sess.getTransaction().begin();
			 Resource resource = (Resource)sess.get(Resource.class, rId);
			 if(resource==null) {
				 return false; // if user is not present do nothing
			 }
		     sess.delete(resource);
			 sess.getTransaction().commit();
		 }
		 catch (RuntimeException e) {
			 sess.getTransaction().rollback();
			 throw e;
		 }
		 return true;
	}

	@Override
	public Resource getById(int rId) {
		SessionFactory sf = createSessionFactory();
		Session sess = sf.openSession();
		Resource resource;
		 try {
			 sess.getTransaction().begin();
			 resource = (Resource)sess.get(Resource.class, rId);
			 sess.getTransaction().commit();
		 }
		 catch (RuntimeException e) {
			 sess.getTransaction().rollback();
			 throw e;
		 }
	    return resource;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Resource> getAllResources() {
		SessionFactory sf = createSessionFactory();
		Session sess = sf.openSession();
		List<Resource> list =null;
		 try {
			 sess.getTransaction().begin();
			 list = sess.createCriteria(Resource.class).list();
			 sess.getTransaction().commit();
		 }
		 catch (RuntimeException e) {
			 sess.getTransaction().rollback();
			 throw e;
		 }
	    return list;
	}

}
