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
import authentication.TokenAuthentication;
import model.Resource;
import services.ResourceService;

@RestController
@RequestMapping("resources")
public class ResourceController {
    
	@Autowired
	ResourceService resourceService;
	TokenAuthentication tokenauth = new TokenAuthentication();
	
	
	//create new resources by sending post req on /resources with the json data of resource
	@RequestMapping(method = RequestMethod.POST, consumes = "application/json")  
    public void create(@RequestParam(value="token", required=true) String token, @RequestBody Resource resource){
		if(tokenauth.checkToken(token) && tokenauth.checkAdmin(token)) {
			resourceService.createResource(resource.getrName(), resource.getrPermissions());
		}
    }
	
	//Return the resource info
    @RequestMapping(value = "/{rId}", method = RequestMethod.GET, produces = "application/json")  
    public Resource resource(@RequestParam(value="token", required=true) String token, @PathVariable int rId){
    	if(tokenauth.checkToken(token) && tokenauth.checkAdmin(token)) {
    		return resourceService.getById(rId);
		}
    	return null;
    }
    
    //update resource
    @RequestMapping(value = "/{rId}", method = RequestMethod.PUT, consumes = "application/json")  
    public void update(@RequestParam(value="token", required=true) String token, @PathVariable int rId,@RequestBody Resource resource){
    	if(tokenauth.checkToken(token) && tokenauth.checkAdmin(token)) {
    		resourceService.updateResource(rId, resource.getrName(), resource.getrPermissions());
		}
    }
    
    //delete resource
    @RequestMapping(value = "/{rId}", method = RequestMethod.DELETE)  
    public void delete(@RequestParam(value="token", required=true) String token, @PathVariable int rId){
    	if(tokenauth.checkToken(token) && tokenauth.checkAdmin(token)) {
    		resourceService.deleteResource(rId);
		}
    }
}