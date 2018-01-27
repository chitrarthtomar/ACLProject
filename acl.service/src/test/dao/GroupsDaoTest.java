package dao;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import model.Groups;
import model.User;

public class GroupsDaoTest {


	GroupsDao groupDao = new GroupsDaoImpl();
	

	@Test
	public void is_createGroup_Working_with_delete () throws Exception{
		boolean test = groupDao.createGroup("abc", "Hello", "admin", "test", null);
		assertEquals(true, test);
		List<Groups> list = groupDao.getAllGroups();
		assertEquals("abc", list.get(list.size()-1).getgName());
		assertEquals("Hello", list.get(list.size()-1).getgDescription());
		test = groupDao.deleteGroup(list.get(list.size()-1).getgId());
		assertEquals(true, test);
	}
	
	@Test
	public void is_delete_empty_User_Working () throws Exception{
		boolean test = groupDao.deleteGroup(3253253);
		assertEquals(false, test);
	}
	
	@Test
	public void is_getAllGroup_Working () throws Exception{
		List<Groups> list = groupDao.getAllGroups();
		assertNotNull(list);
		assertNotEquals(list.size(), 0);
	}
	
	@Test
	public void is__updating_Group_Working () throws Exception{
		boolean test = groupDao.createGroup("abc", "Hello", "admin", "test", null);
		assertEquals(true, test);
		List<Groups> list = groupDao.getAllGroups();
		int gId =list.get(list.size()-1).getgId();
		boolean isupdating = groupDao.updateGroup(gId,"abc", "Hello", "admin", "test", null);
		assertEquals(true ,isupdating );
		Groups group = groupDao.getById(gId);
		boolean actual = groupDao.deleteGroup(gId);
		assertEquals(true, actual);
		assertEquals("abc",group.getgName());
	}
	
	@Test
	public void is_update_empty_Group_Working () throws Exception{
		boolean test = groupDao.updateGroup(356452,"abc", "Hello", "admin", "test", null);
		assertEquals(false, test);
	}
	
	@Test
	public void is_list_of_user_for_group_retreiving () throws Exception{
		List<User> list = new ArrayList<>();
		boolean test = groupDao.createGroup("abc", "Hello", "admin", "test", list);
		assertEquals(true, test);
		UserDao userDao = new UserDaoImpl();
		User user1 = new User("abc", "hello","admin","","", "");
		userDao.createUser("abc", "hello","admin","","", "");
		User user2 = new User("abc2", "hello2","admin","","", "");
		userDao.createUser("abc2", "hello2","admin","","", "");
		List<User> ulist = userDao.getAllUsers();
		user1.setuId(ulist.get(ulist.size()-2).getuId());
		user2.setuId(ulist.get(ulist.size()-1).getuId());
		list.add(user1);
		list.add(user2);
		List<Groups> glist = groupDao.getAllGroups();
		int gId =glist.get(glist.size()-1).getgId();
		boolean isupdating = groupDao.updateGroup(gId,"abc", "Hello", "admin", "test", list);
		assertEquals(true ,isupdating );
		List<User> actual = groupDao.getAllUsers(gId);
		assertEquals(list.get(0).getuId(), actual.get(0).getuId());
		boolean deleted = groupDao.deleteGroup(gId);
		assertEquals(true, deleted);
		boolean isuserdeleted = userDao.deleteUser(list.get(0).getuId());
		assertEquals(true, isuserdeleted);
		isuserdeleted = userDao.deleteUser(list.get(1).getuId());
		assertEquals(true, isuserdeleted);
	}
	
}
