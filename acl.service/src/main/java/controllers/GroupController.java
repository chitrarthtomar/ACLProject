package controllers;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import authentication.EncryptionEngine;
import model.User;
import services.GroupService;

@RestController
public class GroupController {

	@Autowired
	GroupService groupService;
	
    @RequestMapping(value = "/addgroup", method = RequestMethod.POST, produces = "application/json")  
    public ModelAndView add(@RequestParam(value="name", required=true) String name, @RequestParam(value="pass", required=true) String pass){  
        EncryptionEngine encryptionEngine = new EncryptionEngine();
    	System.out.println(name+pass);
    	System.out.println(encryptionEngine.encryptWithMD5("hello"));
        return new ModelAndView("redirect:/ ");
    }
    
    @RequestMapping(value = "/removegroup", method = RequestMethod.POST, produces = "application/json")  
    public ModelAndView removeuser(@RequestParam(value="groupid", required=true) int gId){  
        groupService.deleteGroup(gId);
        return new ModelAndView("redirect:/");
    }
    
    @RequestMapping(value = "/updategroup", method = RequestMethod.POST, produces = "application/json")  
    public ModelAndView updateuser(@RequestParam(value="groupid", required=true) String gid){  
        
        return new ModelAndView("redirect:/");
    }
    @RequestMapping(value = "/addgrouppermission", method = RequestMethod.POST, produces = "application/json")  
    public ModelAndView addgrouppermission(@RequestParam(value="userid", required=true) String uid){  
        
        return new ModelAndView("redirect:/");
    }
}
