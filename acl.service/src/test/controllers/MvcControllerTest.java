package controllers;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import dto.LoginDto;
import dto.LoginResponseDto;

import static org.junit.Assert.assertEquals;
import model.User;
import services.UserService;


public class MvcControllerTest {
	
	MvcController mvcController = new MvcController();
	@Autowired
	UserService userService;

	@Test
    public void is_login_working() throws Exception {
    	LoginDto json = new LoginDto();
    	json.setUsername("abc");
    	json.setPassword("Hello");
        User user = new User("abc", "8b1a9953c4611296a827abf8c4784d7", "admin", "test", "asd", "asd");
        boolean didcreate = userService.createUser("abc", "8b1a9953c4611296a827abf8c4784d7", "admin", "test", "asd", "asd");
        userService.authenticateUser("abc", "8b1a9953c4611296a827abf8c4784d7");
        LoginResponseDto user2 = mvcController.viewuser(json);
        assertEquals(user.getuName(), user2.getUser().getuName());
    }
    
    
}
