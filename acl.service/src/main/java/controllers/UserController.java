package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import authentication.EncryptionEngine;
import services.UserService;

@RestController
public class UserController {

	@Autowired
	UserService userService;
	
    @RequestMapping(value = "/adduser", method = RequestMethod.POST, produces = "application/json")  
    public ModelAndView adduser(@RequestParam(value="name", required=true) String name, @RequestParam(value="pass", required=true) String pass){  
        EncryptionEngine encryptionEngine = new EncryptionEngine();
    	System.out.println(name+pass);
    	System.out.println(encryptionEngine.encryptWithMD5("hello"));
        return new ModelAndView("redirect:/ ");
    }
    
    @RequestMapping(value = "/removeuser", method = RequestMethod.POST, produces = "application/json")  
    public ModelAndView removeuser(@RequestParam(value="userid", required=true) int uId){  
        userService.deleteUser(uId);
        return new ModelAndView("redirect:/ ");
    }
    
    @RequestMapping(value = "/updateuser", method = RequestMethod.POST, produces = "application/json")  
    public ModelAndView updateuser(@RequestParam(value="userid", required=true) String uid){  
        
        return new ModelAndView("redirect:/");
    }
    
    @RequestMapping(value = "/adduserpermission", method = RequestMethod.POST, produces = "application/json")  
    public ModelAndView adduserpermission(@RequestParam(value="userid", required=true) String uid){  
        
        return new ModelAndView("redirect:/");
    }

}
