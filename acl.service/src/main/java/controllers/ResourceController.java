package controllers;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import authentication.TokenAuthentication;
import model.Resource;
import services.ResourceService;

@RestController
@RequestMapping("resources")
public class ResourceController {
	private static final Logger logger = Logger.getLogger(GroupController.class);
	private static final String INFO_1 = "Unauthorized access denied";

	@Autowired
	ResourceService resourceService;
	TokenAuthentication tokenauth = new TokenAuthentication();

	// create new resources by sending post req on /resources with the json data of
	// resource
	@RequestMapping(method = RequestMethod.POST, consumes = "application/json")
	public void create(@RequestParam(value = "token", required = true) String token, @RequestBody Resource resource) {
		if (!tokenauth.checkToken(token) || !tokenauth.checkAdmin(token)) {
			logger.warn(INFO_1);
			return;
		}
		resourceService.createResource(resource.getrName(), resource.getrPermissions());
		logger.info("Resource " + resource.getrName() + " created: ");
	}

	// Return the resource info
	@RequestMapping(value = "/{rId}", method = RequestMethod.GET, produces = "application/json")
	public Resource resource(@RequestParam(value = "token", required = true) String token, @PathVariable int rId) {
		if (!tokenauth.checkToken(token) || !tokenauth.checkAdmin(token)) {
			logger.warn(INFO_1);
			return null;
		}
		logger.info("Returned resource with ID:" + rId);
		return resourceService.getById(rId);
	}

	// update resource
	@RequestMapping(value = "/{rId}", method = RequestMethod.PUT, consumes = "application/json")
	public void update(@RequestParam(value = "token", required = true) String token, @PathVariable int rId,
			@RequestBody Resource resource) {
		if (!tokenauth.checkToken(token) || !tokenauth.checkAdmin(token)) {
			logger.warn(INFO_1);
			return;
		}
		logger.info("Updated resource with ID:" + rId);
		resourceService.updateResource(rId, resource.getrName(), resource.getrPermissions());
	}

	// delete resource
	@RequestMapping(value = "/{rId}", method = RequestMethod.DELETE)
	public void delete(@RequestParam(value = "token", required = true) String token, @PathVariable int rId) {
		if (!tokenauth.checkToken(token) || !tokenauth.checkAdmin(token)) {
			logger.warn(INFO_1);
			return;
		}
		logger.info("Deleted resource with ID:" + rId);
		resourceService.deleteResource(rId);
	}
}