package controllers;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import authentication.EncryptionEngine;
import authentication.TokenAuthentication;
import dto.GroupsListDto;
import dto.LoginDto;
import dto.LoginResponseDto;
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
	TokenAuthentication tokenauth;

	
    @RequestMapping(value = "/login", method = RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE , produces = "application/json")  
    public LoginResponseDto viewuser(@RequestBody LoginDto loginDto){  
        EncryptionEngine encryptionEngine = new EncryptionEngine();
        String username = loginDto.getUsername();
        String password = encryptionEngine.encryptWithMD5(loginDto.getPassword());

        User user =userService.authenticateUser(username, password);
//        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
//        
//        String sessionId = encryptionEngine.encryptWithMD5(timeStamp);
        LoginResponseDto obj = new LoginResponseDto();
        if(user!=null) {
        	String sessionId = tokenauth.addToken(username);
        	obj.setSessionId(sessionId);
        	obj.setUser(user);
        }
        return obj;	
    }
    
    @RequestMapping(value = "/config", method = RequestMethod.POST, produces = "application/json")  
    public ModelAndView configure(@RequestParam(value="userid", required=true) String uid){
    	JSONObject uMandatoryAttributes = new JSONObject();
    	JSONObject uArbitraryAttributes = new JSONObject();
    	String uResource = null;
		userService.createUser("test", "test", "4", uMandatoryAttributes.toString(), uArbitraryAttributes.toString(), uResource);
		return new ModelAndView("redirect:/");
    }
    @RequestMapping(value = "/users", method = RequestMethod.POST, produces = "application/json")  
    public List<UserListDto> users(@RequestParam(value="userid", required=true) String uid){  
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
    public List<GroupsListDto> groups(){
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
    
    @RequestMapping(value = "/groups/{gId}", method = RequestMethod.GET, produces = "application/json")  
    public Groups group(@PathVariable int gId){
        return groupService.getById(gId);
    }
    
    @RequestMapping(value = "/resources", method = RequestMethod.POST, produces = "application/json")  
    public ModelAndView resources(@RequestParam(value="userid", required=true) String uid){  
        List<Resource> resources = resourceService.getAllResources();
        return new ModelAndView("redirect:/");
    }

}