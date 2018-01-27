package controllers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import authentication.TokenAuthentication;
import dto.GroupDto;
import model.Groups;
import model.User;
import services.GroupService;
import services.UserService;

@RestController
@RequestMapping("groups")
public class GroupController {
	private static final Logger logger = Logger.getLogger(GroupController.class);
	private static final String INFO_1 = "Unauthorized access denied";

	@Autowired
	GroupService groupService;
	@Autowired
	UserService userService;
	TokenAuthentication tokenauth = new TokenAuthentication();
	String s = "success";
	String f = "failed";

	// create new group by sending post req on /groups with the json data of group
	@RequestMapping(method = RequestMethod.POST, consumes = "application/json")
	public String create(@RequestParam(value = "token", required = true) String token, @RequestBody Groups group) {
		if (!tokenauth.checkToken(token) || !tokenauth.checkAdmin(token)) {
			logger.warn(INFO_1);
			return f;
		}
		logger.info("Creating a group: " + group.getgDescription());
		groupService.createGroup(group.getgName(), group.getgDescription(), group.getgArbitraryAttributes(),
				group.getgResource(), group.getgUsers());
		return s;
	}

	// Return the group info + extra
	@RequestMapping(value = "/{gId}", method = RequestMethod.GET, produces = "application/json")
	public GroupDto group(@RequestParam(value = "token", required = true) String token, @PathVariable int gId) {
		if (!tokenauth.checkToken(token) || !tokenauth.checkAdmin(token)) {
			logger.warn(INFO_1);
			return null;
		}
		GroupDto groupDto = new GroupDto();
		Groups group = groupService.getById(gId);
		List<User> allUsers = userService.getAllUsers();
		List<User> presentUsers = group.getgUsers();
		List<User> notPresentUsers = new ArrayList<>();
		HashSet<Integer> presentUsersSet = new HashSet<>();
		for (User u : presentUsers) {
			presentUsersSet.add(u.getuId());
		}
		for (User u : allUsers) {
			if (!presentUsersSet.contains(u.getuId()))
				notPresentUsers.add(u);
		}
		groupDto.setOtherUsers(notPresentUsers);
		groupDto.setGroup(group);
		logger.info("Returning group and users");
		return groupDto;
	}

	// update group
	@RequestMapping(value = "/{gId}", method = RequestMethod.PUT, consumes = "application/json")
	@ResponseStatus(HttpStatus.OK)
	public String update(@RequestParam(value = "token", required = true) String token, @PathVariable int gId,
			@RequestBody Groups group) {
		if (!tokenauth.checkToken(token) || !tokenauth.checkAdmin(token)) {
			logger.warn(INFO_1);
			return f;
		}
		groupService.updateGroup(gId, group.getgName(), group.getgDescription(), group.getgArbitraryAttributes(),
				group.getgResource(), group.getgUsers());
		logger.info("Updated group with ID:" + gId);
		return s;
	}

	// delete group
	@RequestMapping(value = "/{gId}", method = RequestMethod.DELETE)
	public String delete(@RequestParam(value = "token", required = true) String token, @PathVariable int gId) {
		if (!tokenauth.checkToken(token) || !tokenauth.checkAdmin(token)) {
			logger.warn(INFO_1);
			return f;
		}
		groupService.deleteGroup(gId);
		logger.info("Deleted group with ID:" + gId);
		return s;
	}
}
