package controllers;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.stereotype.Controller;  
import org.springframework.web.bind.annotation.ModelAttribute;  
import org.springframework.web.bind.annotation.PathVariable;  
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RequestMethod;  
import org.springframework.web.servlet.ModelAndView;

import model.Groups;
import model.Resource;
import model.User;
import services.GroupService;
import services.ResourceService;
import services.UserService;

@Controller  
public class MvcController {  

	@Autowired
	UserService userService;
	@Autowired
	GroupService groupService;
	@Autowired
	ResourceService resourceService;
	
    @RequestMapping("/login")  
    public ModelAndView viewuser(){  
        
    	User user = userService.getById(1);
    	Groups group = groupService.getById(1);
    	Resource resource = resourceService.getById(1);
    	List<User> users = groupService.getAllUsers(1);
    	System.out.println(users.get(0).getuName());
    	System.out.println(user.getuName() + "'s role is: " + user.getuRole());
    	System.out.println(group.getgResource());
    	System.out.println(resource.getrPermissions());
        return new ModelAndView("redirect:/");
    }
 
}