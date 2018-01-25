package controllers;

import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import authentication.EncryptionEngine;
import model.User;
import services.GroupService;
import services.ResourceService;
import services.UserService;

@RestController 
@RequestMapping("abc")
public class MvcController {  

	@Autowired
	UserService userService;
	@Autowired
	GroupService groupService;
	@Autowired
	ResourceService resourceService;

    @RequestMapping(value = "/login", method = RequestMethod.GET, produces = "application/json")  
    public User viewuser(){  
        EncryptionEngine encryptionEngine = new EncryptionEngine();
    	
//    	Resource r1 = new Resource();
//    	r1.setrName("Pantry");
//    	r1.setrPermissions("Enter");
//    	
//    	JSONObject res=new JSONObject();    
//    	res.put("rId",11);    
//    	res.put("rName","Pantry");    
//    	res.put("rPermission","Enter");    
//    	
//    	Groups g1=new Groups();
//    	g1.setgName("Senior Employees");
//    	g1.setgDescription("Access to maximum things");
//    	g1.setgResource(res.toString());
//    	g1.setgArbitraryAttributes(res.toString());
//
//    	
//    	//mandatory attribute
//    	JSONObject manAtt=new JSONObject();    
//    	manAtt.put("email","nishant@gmail.com");
//    	
//    	List<Groups> glistID = new ArrayList<>();
//    	glistID.add(g1);
//    	
//    	
//    	//arbt attribute
//    	JSONObject arbAtt=new JSONObject();    
//    	arbAtt.put("bakwas","blahblah");
    	
//    	User u1=new User();
//    	u1.setuId(1);
//    	u1.setuName("Aditi Giri");
//    	u1.setuPassword("Hello");
//    	u1.setuGroups(res.toString());
//    	u1.setuResource(res.toString());
//    	u1.setuMandatoryAttributes(manAtt.toString());
//    	u1.setuArbitraryAttributes(arbAtt.toString());
    	
//        userService.createUser("nishant", "Hello", manAtt.toString(), arbAtt.toString(), res.toString());
        System.out.println(encryptionEngine.encryptWithMD5("hello"));
//        User u = new User("nishant", "Hello", manAtt.toString(), arbAtt.toString(), res.toString());
        return null;
    }
 
}