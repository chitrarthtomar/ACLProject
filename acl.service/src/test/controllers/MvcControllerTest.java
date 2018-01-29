package controllers;

import org.junit.Test;
import dto.LoginDto;
import dto.LoginResponseDto;

import static org.junit.Assert.assertEquals;
import model.User;
import services.UserService;
import services.UserServiceImpl;


public class MvcControllerTest {
	
	MvcController mvcController = new MvcController();

	UserService userService = new UserServiceImpl();

	@Test
    public void is_login_working() throws Exception {
    	LoginDto json = new LoginDto();
    	json.setUsername("abc");
    	json.setPassword("Hello");
        User user = new User("abc", "8b1a9953c4611296a827abf8c4784d7", "admin", "test", "asd", "asd");
        userService.authenticateUser("abc", "8b1a9953c4611296a827abf8c4784d7");
        LoginResponseDto user2 = mvcController.viewuser(json);
        assertEquals(user.getuName(), user2.getUser().getuName());
    }
    
    
}
