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
		Session session = sf.openSession();
		int rId=-1; // review this later
		 try {
			 session.getTransaction().begin();
			 Resource resource = new Resource(rName,rPermissions);
			 rId= (Integer)session.save(resource);
			 session.getTransaction().commit();
		 }
		 catch (RuntimeException e) {
			 session.getTransaction().rollback();
			 throw e;
		 }
		 return rId;
	}

	@Override
	public void updateResource(int rId, String rName, String rPermissions) {
		SessionFactory sf = createSessionFactory();
		 Session session = sf.openSession();
		 Resource resource = (Resource) session.get(Resource.class, rId);
		 if(resource == null)
			 return;
		 try {
			 session.getTransaction().begin(); 
		     resource.setrName(rName);
		     resource.setrPermissions(rPermissions);
		     session.update(resource);
			 session.getTransaction().commit();
		 }
		 catch (RuntimeException e) {
			 session.getTransaction().rollback();
			 throw e;
		 }
		
	}

	@Override
	public boolean deleteResource(int rId) {
		SessionFactory sf = createSessionFactory();
		 Session session = sf.openSession();
		 try {
			 session.getTransaction().begin();
			 Resource resource = (Resource)session.get(Resource.class, rId);
			 if(resource==null) {
				 return false; // if user is not present do nothing
			 }
		     session.delete(resource);
			 session.getTransaction().commit();
		 }
		 catch (RuntimeException e) {
			 session.getTransaction().rollback();
			 throw e;
		 }
		 return true;
	}

	@Override
	public Resource getById(int rId) {
		SessionFactory sf = createSessionFactory();
		Session session = sf.openSession();
		Resource resource;
		 try {
			 session.getTransaction().begin();
			 resource = (Resource)session.get(Resource.class, rId);
			 session.getTransaction().commit();
		 }
		 catch (RuntimeException e) {
			 session.getTransaction().rollback();
			 throw e;
		 }
	    return resource;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Resource> getAllResources() {
		SessionFactory sf = createSessionFactory();
		Session session = sf.openSession();
		List<Resource> list =null;
		 try {
			 session.getTransaction().begin();
			 list = session.createCriteria(Resource.class).list();
			 session.getTransaction().commit();
		 }
		 catch (RuntimeException e) {
			 session.getTransaction().rollback();
			 throw e;
		 }
	    return list;
	}

}
