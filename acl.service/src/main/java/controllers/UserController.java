package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import authentication.EncryptionEngine;
import authentication.TokenAuthentication;
import model.User;
import services.UserService;

@RestController
@RequestMapping("users")
public class UserController {
	@Autowired
	UserService userService;
	TokenAuthentication tokenauth = new TokenAuthentication();
	EncryptionEngine encryptionEngine = new EncryptionEngine();
	String s = "success";
	String f = "failed";

	@RequestMapping(method = RequestMethod.POST, produces = "application/json")
	public String create(@RequestParam(value = "token", required = true) String token, @RequestBody User user) {
		if (tokenauth.checkToken(token) && tokenauth.checkAdmin(token)) {
			userService.createUser(user.getuName(), encryptionEngine.encryptWithMD5(user.getuPassword()),
					user.getuRole(), user.getuMandatoryAttributes(), user.getuArbitraryAttributes(),
					user.getuResource());
			return s;
		} else
			return f;
	}
	
	@RequestMapping(value = "/{uId}", method = RequestMethod.GET, produces = "application/json")
	public User user(@RequestParam(value = "token", required = true) String token, @PathVariable int uId) {
		if (tokenauth.checkToken(token) && tokenauth.checkAdmin(token)) {
			return userService.getById(uId);
		}
		return null;
	}

	@RequestMapping(value = "/{uId}", method = RequestMethod.DELETE, produces = "application/json")
	public String delete(@RequestParam(value = "token", required = true) String token, @PathVariable int uId) {
		if (tokenauth.checkToken(token) && tokenauth.checkAdmin(token)) {
			userService.deleteUser(uId);
			return s;
		} else
			return f;
	}

	@RequestMapping(value = "/{uId}", method = RequestMethod.PUT, produces = "application/json")
	public String update(@RequestParam(value = "token", required = true) String token, @RequestBody User user, @PathVariable int uId) {
		if (tokenauth.checkToken(token) && tokenauth.checkAdmin(token)) {
			boolean result =userService.updateUser(uId, user.getuName(), encryptionEngine.encryptWithMD5(user.getuPassword()),
					user.getuRole(), user.getuMandatoryAttributes(), user.getuArbitraryAttributes(),
					user.getuResource());
			System.out.println("heaven: " + result);
			return s;
		} else
			return f;
	}
}
