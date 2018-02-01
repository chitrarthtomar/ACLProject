package controllers;

import org.apache.log4j.Logger;
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
	private static final Logger logger = Logger.getLogger(GroupController.class);
	private static final String INFO_1 = "Unauthorized access denied";

	@Autowired
	UserService userService;
	@Autowired
	TokenAuthentication tokenauth;
	@Autowired
	EncryptionEngine encryptionEngine;


	@RequestMapping(method = RequestMethod.POST)
	public void create(@RequestParam(value = "token", required = true) String token, @RequestBody User user) {
		if (!tokenauth.checkToken(token) || !tokenauth.checkAdmin(token)) {
			logger.warn(INFO_1);
			return;
		}
		userService.createUser(user.getuName(), encryptionEngine.encryptWithMD5(user.getuPassword()), user.getuRole(),
				user.getuMandatoryAttributes(), user.getuArbitraryAttributes(), user.getuResource());
		logger.info("Created user: " + user.getuName());
		return;
	}

	@RequestMapping(value = "/{uId}", method = RequestMethod.GET, produces = "application/json")
	public User user(@RequestParam(value = "token", required = true) String token, @PathVariable int uId) {
		if (!tokenauth.checkToken(token) || !tokenauth.checkAdmin(token)) {
			logger.warn(INFO_1);
			return null;
		}
		logger.info("Returned user with ID: " + uId);
		return userService.getById(uId);
	}

	@RequestMapping(value = "/{uId}", method = RequestMethod.DELETE)
	public void delete(@RequestParam(value = "token", required = true) String token, @PathVariable int uId) {
		if (!tokenauth.checkToken(token) || !tokenauth.checkAdmin(token)) {
			logger.warn(INFO_1);
			return;
		}
		userService.deleteUser(uId);
		logger.info("Deleted user with ID: " + uId);
		return;
	}

	@RequestMapping(value = "/{uId}", method = RequestMethod.PUT)
	public void update(@RequestParam(value = "token", required = true) String token, @RequestBody User user,
			@PathVariable int uId) {
		if (!tokenauth.checkToken(token) || !tokenauth.checkAdmin(token)) {
			logger.warn(INFO_1);
			return;
		}
		userService.updateUser(uId, user.getuName(), encryptionEngine.encryptWithMD5(user.getuPassword()),
				user.getuRole(), user.getuMandatoryAttributes(), user.getuArbitraryAttributes(), user.getuResource());
		logger.info("Updated user with ID: " + uId);
		return;
	}
}
