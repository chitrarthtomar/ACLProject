package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import authentication.EncryptionEngine;
import model.Resource;
import services.ResourceService;

@RestController
@RequestMapping("resources")
public class ResourceController {
    
	@Autowired
	ResourceService resourceService;
	
	
	//create new resources by sending post req on /resources with the json data of resource
	@RequestMapping(method = RequestMethod.POST, consumes = "application/json")  
    public void create(@RequestBody Resource resource){
    		resourceService.createResource(resource.getrName(), resource.getrPermissions());
    }
	
	//Return the resource info
    @RequestMapping(value = "/{rId}", method = RequestMethod.GET, produces = "application/json")  
    public Resource resource(@PathVariable int rId){
    	return resourceService.getById(rId);
    }
    
    //update resource
    @RequestMapping(value = "/{rId}", method = RequestMethod.PUT, consumes = "application/json")  
    public void update(@PathVariable int rId,@RequestBody Resource resource){
    	resourceService.updateResource(rId, resource.getrName(), resource.getrPermissions());
    }
    
    //delete resource
    @RequestMapping(value = "/{rId}", method = RequestMethod.DELETE)  
    public void delete(@PathVariable int rId){
    	resourceService.deleteResource(rId);
    }
	
//    @RequestMapping(value = "/addresource", method = RequestMethod.POST, produces = "application/json")  
//    public ModelAndView addresource(@RequestParam(value="name", required=true) String name, @RequestParam(value="pass", required=true) String pass){  
//        EncryptionEngine encryptionEngine = new EncryptionEngine();
//    	System.out.println(name+pass);
//    	System.out.println(encryptionEngine.encryptWithMD5("hello"));
//        return new ModelAndView("redirect:/");
//    }
//    
//    @RequestMapping(value = "/removeresource", method = RequestMethod.POST, produces = "application/json")  
//    public ModelAndView removeuser(@RequestParam(value="resourceid", required=true) int rId){  
//        resourceService.deleteResource(rId);
//        return new ModelAndView("redirect:/");
//    }
//    
//    @RequestMapping(value = "/updateresource", method = RequestMethod.POST, produces = "application/json")  
//    public ModelAndView updateuser(@RequestParam(value="resourceid", required=true) String rid){  
//        
//        return new ModelAndView("redirect:/");
//    }
}
