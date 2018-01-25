package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import authentication.EncryptionEngine;
import services.ResourceService;

@RestController
public class ResourceController {
    
	@Autowired
	ResourceService resourceService;
	
    @RequestMapping(value = "/addresource", method = RequestMethod.POST, produces = "application/json")  
    public ModelAndView addresource(@RequestParam(value="name", required=true) String name, @RequestParam(value="pass", required=true) String pass){  
        EncryptionEngine encryptionEngine = new EncryptionEngine();
    	System.out.println(name+pass);
    	System.out.println(encryptionEngine.encryptWithMD5("hello"));
        return new ModelAndView("redirect:/");
    }
    
    @RequestMapping(value = "/removeresource", method = RequestMethod.POST, produces = "application/json")  
    public ModelAndView removeuser(@RequestParam(value="resourceid", required=true) int rId){  
        resourceService.deleteResource(rId);
        return new ModelAndView("redirect:/");
    }
    
    @RequestMapping(value = "/updateresource", method = RequestMethod.POST, produces = "application/json")  
    public ModelAndView updateuser(@RequestParam(value="resourceid", required=true) String rid){  
        
        return new ModelAndView("redirect:/");
    }
}
