package dto;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import model.Groups;
import model.User;

public class AllDtoTest {

	@Test
	public void testing_logindto() {
		LoginDto loginDto=new LoginDto();
		loginDto.setUsername("abc");
		loginDto.setPassword("qwe");
		assertEquals("abc",loginDto.getUsername());
		assertEquals("qwe",loginDto.getPassword());
	}

	@Test
	public void testing_groupto() {
		GroupDto groupDto = new GroupDto();
		groupDto.setGroup(new Groups());
		List<User> list = new ArrayList<>();
		groupDto.setOtherUsers(list);
		assertEquals(Groups.class,groupDto.getGroup().getClass());
		assertEquals(list.getClass(),groupDto.getOtherUsers().getClass());
	}
	
	@Test
	public void testing_loginResponsedto() {
		LoginResponseDto loginResponseDto = new LoginResponseDto();
		loginResponseDto.setSessionId("dfghjkl");
		loginResponseDto.setUser(new User());
		assertEquals("dfghjkl", loginResponseDto.getSessionId());
		assertEquals(loginResponseDto.getUser().getClass(), User.class);
	}
	
	@Test
	public void testing_groupListdto() {
		GroupsListDto groupListDto = new GroupsListDto();
		groupListDto.setgId(123);
		groupListDto.setgName("GroupTest");
		assertEquals(123,groupListDto.getgId());
		assertEquals("GroupTest",groupListDto.getgName());
		
	}
	@Test
	public void testing_resourceListdto() {
		ResourceListDto resourceListDto = new ResourceListDto();
		resourceListDto.setrId(1234);
		resourceListDto.setrName("ResourceTest");
		assertEquals(1234,resourceListDto.getrId());
		assertEquals("ResourceTest",resourceListDto.getrName());
		
	}

	@Test
	public void testing_userListdto() {
		UserListDto userListDto = new UserListDto();
		userListDto.setuId(12345);
		userListDto.setuName("UserTest");
		assertEquals(12345,userListDto.getuId());
		assertEquals("UserTest",userListDto.getuName());
		
	}
}
