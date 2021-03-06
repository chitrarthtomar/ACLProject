package dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import controllers.GroupController;
import model.Groups;
import model.User;
import services.GetSessionFactory;

@Transactional
@Repository
public class GroupsDaoImpl implements GroupsDao {
	private static final Logger logger = Logger.getLogger(GroupController.class);
	private static final String INFO_1 = "Runtime Exception occured:";


	@Override
	public boolean createGroup(String gName, String gDescription, String gArbitraryAttributes, String gResource,
			List<User> gUsers) {
		SessionFactory sf = GetSessionFactory.createSessionFactory();
		Session sess = sf.openSession();
		try {
			sess.getTransaction().begin();
			Groups group = new Groups(gName, gDescription, gArbitraryAttributes, gResource);
			group.setgUsers(null);
			sess.save(group);
			sess.getTransaction().commit();
		} catch (RuntimeException e) {
			sess.getTransaction().rollback();
			logger.info(INFO_1 + e.getMessage());
			return false;

		}
		return true;
	}

	@Override
	public boolean updateGroup(int gId, String gName, String gDescription, String gArbitraryAttributes,
			String gResource, List<User> gUsers) {
		SessionFactory sf = GetSessionFactory.createSessionFactory();
		Session sess = sf.openSession();
		Groups prevGroup = (Groups) sess.get(Groups.class, gId);

		if (prevGroup == null)
			return false;
		try {
			sess.getTransaction().begin();
			prevGroup.setgArbitraryAttributes(gArbitraryAttributes);
			prevGroup.setgDescription(gDescription);
			prevGroup.setgName(gName);
			prevGroup.setgResource(gResource);
			prevGroup.setgUsers(gUsers);
			sess.update(prevGroup);
			sess.getTransaction().commit();
		} catch (RuntimeException e) {
			sess.getTransaction().rollback();
			logger.info(INFO_1 + e.getMessage());
			return false;
		}
		return true;
	}

	@Override
	public boolean deleteGroup(int gId) {
		SessionFactory sf = GetSessionFactory.createSessionFactory();
		Session sess = sf.openSession();
		try {
			sess.getTransaction().begin();
			Groups group = (Groups) sess.get(Groups.class, gId);
			if (group == null) {
				return false; // if user is not present do nothing
			}
			group.setgUsers(null);
			sess.update(group);
			sess.delete(group);
			sess.getTransaction().commit();
		} catch (RuntimeException e) {
			sess.getTransaction().rollback();
			logger.info(INFO_1 + e.getMessage());
			return false;
		}
		return true;
	}

	@Override
	public Groups getById(int gId) {
		SessionFactory sf = GetSessionFactory.createSessionFactory();
		Session sess = sf.openSession();
		Groups group;
		try {
			sess.getTransaction().begin();
			group = (Groups) sess.get(Groups.class, gId);
			sess.getTransaction().commit();
		} catch (RuntimeException e) {
			sess.getTransaction().rollback();
			logger.info(INFO_1 + e.getMessage());
			return null;
		}
		return group;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Groups> getAllGroups() {
		SessionFactory sf = GetSessionFactory.createSessionFactory();
		Session sess = sf.openSession();
		List<Groups> list = null;
		try {
			sess.getTransaction().begin();
			list = sess.createCriteria(Groups.class).list();
			sess.getTransaction().commit();
		} catch (RuntimeException e) {
			sess.getTransaction().rollback();
			logger.info(INFO_1 + e.getMessage());
			return new ArrayList<>();
		}
		return list;
	}

	@Override
	public List<User> getAllUsers(int gId) {
		SessionFactory sf = GetSessionFactory.createSessionFactory();
		Session sess = sf.openSession();
		List<User> list = null;
		try {
			sess.getTransaction().begin();
			Groups group = (Groups) sess.get(Groups.class, gId);
			if (group != null)
				list = group.getgUsers();
			sess.getTransaction().commit();
		} catch (RuntimeException e) {
			sess.getTransaction().rollback();
			logger.info(INFO_1 + e.getMessage());
			return new ArrayList<>();
		}
		return list;
	}
}
