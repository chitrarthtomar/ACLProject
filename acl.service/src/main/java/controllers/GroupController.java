package controllers;

import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.http.HttpStatus;

import authentication.EncryptionEngine;
import authentication.TokenAuthentication;
import dto.GroupDto;
import model.Groups;
import model.Resource;
import services.GroupService;
import services.ResourceService;

@RestController
@RequestMapping("groups")
public class GroupController {

	@Autowired
	GroupService groupService;
	@Autowired
	ResourceService resourceService;
    TokenAuthentication tokenauth = new TokenAuthentication();
    String s="success";
    String f="failed";
	
	//create new group by sending post req on /groups with the json data of group
	@RequestMapping(method = RequestMethod.POST, consumes = "application/json")  
    public String create(@RequestParam(value="token", required=true) String token, @RequestBody Groups group){
		if(tokenauth.checkToken(token)) {
			groupService.createGroup(group.getgName(), group.getgDescription(), group.getgArbitraryAttributes(), group.getgResource(), group.getgUsers());
			return s;
		}
		return f;
    }
	
	//Return the group info + extra
    @RequestMapping(value = "/{gId}", method = RequestMethod.GET, produces = "application/json")  
    public GroupDto group(@RequestParam(value="token", required=true) String token, @PathVariable int gId){
    	if(!tokenauth.checkToken(token))
    		return null;
    	GroupDto groupDto = new GroupDto();
    	Groups group = groupService.getById(gId);
    	
    	List<Resource> allRes = resourceService.getAllResources();
    	groupDto.setResources(allRes);
    	groupDto.setGroup(group);
    	return groupDto;
    }
    
    //update group
    @RequestMapping(value = "/{gId}", method = RequestMethod.PUT, consumes = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public String update(@RequestParam(value="token", required=true) String token, @PathVariable int gId,@RequestBody Groups group){
    	if(!tokenauth.checkToken(token))
    		return f;
    	groupService.updateGroup(gId, group.getgName(), group.getgDescription(), group.getgArbitraryAttributes(), group.getgResource());
    	return s;
    }
    
    //delete group
    @RequestMapping(value = "/{gId}", method = RequestMethod.DELETE)  
    public String delete(@RequestParam(value="token", required=true) String token, @PathVariable int gId){
    	if(!tokenauth.checkToken(token))
    		return f;
    	groupService.deleteGroup(gId);
    	return s;
    }
    /*
	
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
    */
}
