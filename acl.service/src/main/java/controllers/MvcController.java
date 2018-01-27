package controllers;

import java.util.ArrayList;
import java.util.List;


import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import authentication.EncryptionEngine;
import authentication.TokenAuthentication;
import dto.ConfigDto;
import dto.GroupsListDto;
import dto.LoginDto;
import dto.LoginResponseDto;
import dto.ResourceListDto;
import dto.UserListDto;
import model.Groups;
import model.Resource;
import model.User;
import services.GroupService;
import services.ResourceService;
import services.UserService;

@RestController 
@RequestMapping("/")
public class MvcController {  

	@Autowired
	UserService userService;
	@Autowired
	GroupService groupService;
	@Autowired
	ResourceService resourceService;
	TokenAuthentication tokenauth = new TokenAuthentication();
    String s="success";
    String f="failed";
    @RequestMapping(value = "/login", method = RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE , produces = "application/json")  
    public LoginResponseDto viewuser(@RequestBody LoginDto loginDto){  
        EncryptionEngine encryptionEngine = new EncryptionEngine();
        String username = loginDto.getUsername();
        String password = encryptionEngine.encryptWithMD5(loginDto.getPassword());

        User user = userService.authenticateUser(username, password);
        LoginResponseDto obj = null;
        if(user!=null) {
        	obj = new LoginResponseDto();
        	String token = tokenauth.addToken(username,user.getuRole());
        	obj.setSessionId(token);
        	obj.setUser(user);
        }
        return obj;
    }
    
    @RequestMapping(value = "/config", method = RequestMethod.POST, produces = "application/json")  
    public String configure(@RequestParam(value="token", required=true) String token, @RequestBody ConfigDto config){
		if(tokenauth.checkToken(token) && tokenauth.checkAdmin(token)) {
			String uResource = null;
			String uArbitraryAttributes=null;
			User dummyGuy = userService.authenticateUser("test", "test");;
			if(dummyGuy==null)
				userService.createUser("test", "test", "dummy", config.getMandatoryAttributes().toString(), uArbitraryAttributes, uResource);
			else
				userService.updateUser(dummyGuy.getuId(),"test", "test", "dummy", config.getMandatoryAttributes().toString(), uArbitraryAttributes, uResource);
			return s;
		}
		return f;
	}
    
    @RequestMapping(value = "/users", method = RequestMethod.GET, produces = "application/json")  
    public List<UserListDto> users(@RequestParam(value="token", required=true) String token){  
    	if(!tokenauth.checkToken(token) || !tokenauth.checkAdmin(token))
    		return null;
    	List<User> users = userService.getAllUsers();
        List<UserListDto> userList = new ArrayList<>();
        for(User u:users) {
        	UserListDto t = new UserListDto();
        	t.setuId(u.getuId());
        	t.setuName(u.getuName());
        	userList.add(t);
        }
        return userList;
    }
    
    @RequestMapping(value = "/groups", method = RequestMethod.GET, produces = "application/json")  
    public List<GroupsListDto> groups(@RequestParam(value="token", required=true) String token){
    	if(!tokenauth.checkToken(token) || !tokenauth.checkAdmin(token))
    		return null;
        List<Groups> groups = groupService.getAllGroups();
        List<GroupsListDto> groupList = new ArrayList<>();
        for(Groups g:groups) {
        	GroupsListDto t = new GroupsListDto();
        	t.setgId(g.getgId());
        	t.setgName(g.getgName());
        	groupList.add(t);
        }
        return groupList;
    }
    
    @RequestMapping(value = "/resources", method = RequestMethod.GET, produces = "application/json")  
    public List<ResourceListDto> resources(@RequestParam(value="token", required=true) String token){
    	if(!tokenauth.checkToken(token) || !tokenauth.checkAdmin(token))
    		return null;
        List<Resource> resources = resourceService.getAllResources();
        List<ResourceListDto> resourceList = new ArrayList<>();
        for(Resource r:resources) {
        	ResourceListDto t = new ResourceListDto();
        	t.setrId(r.getrId());
        	t.setrName(r.getrName());
        	resourceList.add(t);
        }
        return resourceList;
    }

}