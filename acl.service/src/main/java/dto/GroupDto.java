package dto;

import java.util.List;

import model.Groups;
import model.Resource;

public class GroupDto {
	Groups group;
	List<Resource> resources;
	public Groups getGroup() {
		return group;
	}
	public void setGroup(Groups group) {
		this.group = group;
	}
	public List<Resource> getResources() {
		return resources;
	}
	public void setResources(List<Resource> resources) {
		this.resources = resources;
	}	
}