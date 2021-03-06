package dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import controllers.GroupController;
import model.Resource;
import services.GetSessionFactory;

@Transactional
@Repository
public class ResourceDaoImpl implements ResourceDao {
	private static final Logger logger = Logger.getLogger(GroupController.class);
	private static final String INFO_1 = "Runtime Exception occured:";



	@Override
	public boolean createResource(String rName, String rPermissions) {
		SessionFactory sf = GetSessionFactory.createSessionFactory();
		Session session = sf.openSession();
		try {
			session.getTransaction().begin();
			Resource resource = new Resource(rName, rPermissions);
			session.save(resource);
			session.getTransaction().commit();
		} catch (RuntimeException e) {
			session.getTransaction().rollback();
			logger.info(INFO_1 + e.getMessage());
			return false;
		}
		return true;
	}

	@Override
	public boolean updateResource(int rId, String rName, String rPermissions) {
		SessionFactory sf = GetSessionFactory.createSessionFactory();
		Session session = sf.openSession();
		Resource resource = (Resource) session.get(Resource.class, rId);
		if (resource == null)
			return false;
		try {
			session.getTransaction().begin();
			resource.setrName(rName);
			resource.setrPermissions(rPermissions);
			session.update(resource);
			session.getTransaction().commit();
		} catch (RuntimeException e) {
			session.getTransaction().rollback();
			logger.info(INFO_1 + e.getMessage());
			return false;
		}
		return true;

	}

	@Override
	public boolean deleteResource(int rId) {
		SessionFactory sf = GetSessionFactory.createSessionFactory();
		Session session = sf.openSession();
		try {
			session.getTransaction().begin();
			Resource resource = (Resource) session.get(Resource.class, rId);
			if (resource == null) {
				return false; // if user is not present do nothing
			}
			session.delete(resource);
			session.getTransaction().commit();
		} catch (RuntimeException e) {
			session.getTransaction().rollback();
			logger.info(INFO_1 + e.getMessage());
			return false;
		}
		return true;
	}

	@Override
	public Resource getById(int rId) {
		SessionFactory sf = GetSessionFactory.createSessionFactory();
		Session session = sf.openSession();
		Resource resource;
		try {
			session.getTransaction().begin();
			resource = (Resource) session.get(Resource.class, rId);
			session.getTransaction().commit();
		} catch (RuntimeException e) {
			session.getTransaction().rollback();
			logger.info(INFO_1 + e.getMessage());
			return null;
		}
		return resource;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Resource> getAllResources() {
		SessionFactory sf = GetSessionFactory.createSessionFactory();
		Session session = sf.openSession();
		List<Resource> list = null;
		try {
			session.getTransaction().begin();
			list = session.createCriteria(Resource.class).list();
			session.getTransaction().commit();
		} catch (RuntimeException e) {
			session.getTransaction().rollback();
			logger.info(INFO_1 + e.getMessage());
			return new ArrayList<>();
		}
		return list;
	}

}
