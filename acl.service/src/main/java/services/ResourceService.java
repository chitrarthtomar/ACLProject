package services;

import java.util.List;

import model.Resource;

public interface ResourceService {
	// method to create Resource
	public boolean createResource(String rName, String rPermissions);

	// method to update Resource
	public boolean updateResource(int rId, String rName, String rPermissions);

	// method to delete Resource
	public boolean deleteResource(int rId);

	// method to return one Resource of given id
	public Resource getById(int id);

	// method to return all Resource
	public List<Resource> getAllResources();
}
