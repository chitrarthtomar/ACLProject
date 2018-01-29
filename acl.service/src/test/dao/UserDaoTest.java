package dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import model.User;

public class UserDaoTest {


	UserDao userDao = new UserDaoImpl();
	

	@Test
	public void is_createUser_Working () throws Exception{
		boolean test = userDao.createUser("abc", "Hello", "admin", "test", "asd", "asd");
		boolean actual = userDao.deleteUser(userDao.authUser("abc", "Hello").getuId());
		assertEquals(actual, test);
	}
	
	@Test
	public void is_delete_empty_User_Working () throws Exception{
		boolean test = userDao.deleteUser(12343);
		assertEquals(false, test);
	}
	
	@Test
	public void is_getAllUser_Working () throws Exception{
		List<User> list = userDao.getAllUsers();
		assertNotNull(list);
		assertNotEquals(list.size(), 0);
	}
	
	@Test
	public void is_updating_User_Working () throws Exception{
		boolean test = userDao.createUser("abc", "Hello", "admin", "test", "asd", "asd");
		assertEquals(true, test);
		int uId = userDao.authUser("abc", "Hello").getuId();
		boolean isupdating = userDao.updateUser(uId,"abc", "hey", "admin", "test", "asd", "asd");
		assertEquals(true ,isupdating );
		User user = userDao.getUserById(uId);
		boolean actual = userDao.deleteUser(uId);
		assertEquals(true,actual);
		assertEquals("hey",user.getuPassword());
	}
	
	@Test
	public void is_update_empty_User_Working () throws Exception{
		boolean test = userDao.updateUser(234557,"abc", "hey", "admin", "test", "asd", "asd");
		assertEquals(false, test);
	}
}
