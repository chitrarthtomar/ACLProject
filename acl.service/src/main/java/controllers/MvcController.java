package controllers;

import java.util.ArrayList;
import java.util.Comparator;
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
import dao.UserDao;
import services.UserService;

@Controller  
public class MvcController {  

	@Autowired
	UserService userService;
	
    @RequestMapping("/login")  
    public ModelAndView viewuser(){  
        
    	Resource r1 = new Resource();
    	r1.setrName("Pantry");
    	r1.setrPermissions("Enter");
    	
    	JSONObject res=new JSONObject();    
    	res.put("rId",11);    
    	res.put("rName","Pantry");    
    	res.put("rPermission","Enter");    
    	
    	Groups g1=new Groups();
    	g1.setgName("Senior Employees");
    	g1.setgDescription("Access to maximum things");
    	g1.setgResource(res.toString());
    	g1.setgArbitraryAttributes(res.toString());

    	
    	//mandatory attribute
    	JSONObject manAtt=new JSONObject();    
    	manAtt.put("email","nishant@gmail.com");
    	
    	List<Groups> glistID = new ArrayList<>();
    	glistID.add(g1);
    	
    	
    	//arbt attribute
    	JSONObject arbAtt=new JSONObject();    
    	arbAtt.put("bakwas","blahblah");
    	
//    	User u1=new User();
//    	u1.setuId(1);
//    	u1.setuName("Aditi Giri");
//    	u1.setuPassword("Hello");
//    	u1.setuGroups(res.toString());
//    	u1.setuResource(res.toString());
//    	u1.setuMandatoryAttributes(manAtt.toString());
//    	u1.setuArbitraryAttributes(arbAtt.toString());
    	
        userService.createUser("nishant", "Hello", manAtt.toString(), arbAtt.toString(), res.toString());
        return new ModelAndView("redirect:/");
    }
 
}