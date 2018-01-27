package services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.ResourceDao;
import model.Resource;

@Service("resourceService")
public class ResourceServiceImpl implements ResourceService{
	
	@Autowired
	ResourceDao resourceDao;

	@Override
	public boolean createResource(String rName, String rPermissions) {
		return resourceDao.createResource(rName, rPermissions);
		
	}

	@Override
	public boolean updateResource(int rId, String rName, String rPermissions) {
		return resourceDao.updateResource(rId, rName, rPermissions);
	}

	@Override
	public boolean deleteResource(int rId) {
		resourceDao.deleteResource(rId);
		return false;
	}

	@Override
	public Resource getById(int id) {
		return resourceDao.getById(id);
	}

	@Override
	public List<Resource> getAllResources() {
		return resourceDao.getAllResources();
	}

}
