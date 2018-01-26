package controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import authentication.EncryptionEngine;
import dto.LoginDto;
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

	
    @RequestMapping(value = "/login", method = RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE , produces = "application/json")  
    public User viewuser(@RequestBody LoginDto loginDto){  
        EncryptionEngine encryptionEngine = new EncryptionEngine();
        String username = loginDto.getUsername();
        String password = encryptionEngine.encryptWithMD5(loginDto.getUsername());
        User user =userService.authenticateUser(username, password);
    	return user;
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
    public ModelAndView users(@RequestParam(value="userid", required=true) String uid){  
        List<User> users = userService.getAllUsers();
        return new ModelAndView("redirect:/");
    }
    @RequestMapping(value = "/groups", method = RequestMethod.POST, produces = "application/json")  
    public ModelAndView groups(@RequestParam(value="userid", required=true) String uid){  
        List<Groups> groups = groupService.getAllGroups();
        return new ModelAndView("redirect:/");
    }
    @RequestMapping(value = "/resources", method = RequestMethod.POST, produces = "application/json")  
    public ModelAndView resources(@RequestParam(value="userid", required=true) String uid){  
        List<Resource> resources = resourceService.getAllResources();
        return new ModelAndView("redirect:/");
    }

}