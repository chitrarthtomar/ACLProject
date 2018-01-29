package dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import controllers.GroupController;
import dao.UserDao;
import model.User;
import services.GetSessionFactory;

@Repository
@Transactional
public class UserDaoImpl implements UserDao {
	private static final Logger logger = Logger.getLogger(GroupController.class);
	private static final String INFO_1 = "Runtime Exception occured:";




	// method to create user
	public boolean createUser(String uName, String uPassword, String uRole, String uMandatoryAttributes,
		String uArbitraryAttributes, String uResource) {
		SessionFactory sf = GetSessionFactory.createSessionFactory();
		Session sess = sf.openSession();
		try {
			sess.getTransaction().begin();
			User user = new User(uName, uPassword, uRole, uMandatoryAttributes, uArbitraryAttributes, uResource);
			sess.save(user);
			sess.getTransaction().commit();
		} catch (RuntimeException e) {
			sess.getTransaction().rollback();
			logger.info(INFO_1 + e.getMessage());
			return false;
		}
		return true;
	}

	// method to update employee
	public boolean updateUser(int uId, String uName, String uPassword, String uRole, String uMandatoryAttributes,
			String uArbitraryAttributes, String uResource) {
		SessionFactory sf = GetSessionFactory.createSessionFactory();
		Session session = sf.openSession();
		User user = (User) session.get(User.class, uId);
		if (user == null)
			return false;
		try {
			session.getTransaction().begin();
			user.setuName(uName);
			user.setuPassword(uPassword);
			user.setuResource(uResource);
			user.setuArbitraryAttributes(uArbitraryAttributes);
			user.setuMandatoryAttributes(uMandatoryAttributes);
			user.setuRole(uRole);
			session.update(user);
			session.getTransaction().commit();
		} catch (RuntimeException e) {
			session.getTransaction().rollback();
			logger.info(INFO_1 + e.getMessage());
			return false;
		}
		return true;
	}

	// method to delete employee
	public boolean deleteUser(int uId) {
		SessionFactory sf = GetSessionFactory.createSessionFactory();
		Session sess = sf.openSession();
		try {
			sess.getTransaction().begin();
			User user = (User) sess.get(User.class, uId);
			if (user == null) {
				return false; // if user is not present do nothing
			}
			sess.delete(user);
			sess.getTransaction().commit();
		} catch (RuntimeException e) {
			sess.getTransaction().rollback();
			logger.info(INFO_1 + e.getMessage());
			return false;
		}
		return true;
	}

	// method to return all employees
	@SuppressWarnings("unchecked")
	public List<User> getAllUsers() {
		SessionFactory sf = GetSessionFactory.createSessionFactory();
		Session sess = sf.openSession();
		List<User> list = null;
		try {
			sess.getTransaction().begin();
			list = sess.createCriteria(User.class).list();
			sess.getTransaction().commit();
		} catch (RuntimeException e) {
			sess.getTransaction().rollback();
			logger.info(INFO_1 + e.getMessage());
			return new ArrayList<>();
		}
		return list;
	}

	// method to return one employee of given id
	public User getUserById(int uId) {
		SessionFactory sf = GetSessionFactory.createSessionFactory();
		Session sess = sf.openSession();
		User user;
		try {
			sess.getTransaction().begin();
			user = (User) sess.get(User.class, uId);
			sess.getTransaction().commit();
		} catch (RuntimeException e) {
			sess.getTransaction().rollback();
			logger.info(INFO_1 + e.getMessage());
			return null;
		}
		return user;
	}

	@Override
	public User authUser(String name, String password) {
		SessionFactory sf = GetSessionFactory.createSessionFactory();
		Session sess = sf.openSession();
		User user = null;
		try {
			sess.getTransaction().begin();
			String hq2 = "From User where uName = :param1 AND uPassword = :param2";
			Query query = sess.createQuery(hq2);
			query.setString("param1", name);
			query.setString("param2", password);
			@SuppressWarnings("unchecked")
			List<User> list = query.list();
			if (!list.isEmpty())
				user = list.get(0);
			sess.getTransaction().commit();
		} catch (RuntimeException e) {
			sess.getTransaction().rollback();
			logger.info(INFO_1 + e.getMessage());
			return null;
		}
		return user;
	}
}
