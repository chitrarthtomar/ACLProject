package services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.GroupsDao;
import model.Groups;
import model.User;

@Service("groupService")
public class GroupServiceImpl implements GroupService{
	
	@Autowired
	GroupsDao groupDao;

	// ***************REVIEW LATER**********************
	@Override
	public boolean createGroup(String gName, String gDescription, String gArbitraryAttributes, String gResource, List<User> gUsers) {
		return groupDao.createGroup(gName, gDescription, gArbitraryAttributes, gResource, gUsers);
	}

	@Override
	public boolean updateGroup(int gId, String gName, String gDescription, String gArbitraryAttributes, String gResource, List<User> gUsers) {
		return groupDao.updateGroup(gId, gName, gDescription, gArbitraryAttributes, gResource, gUsers);
	}

	@Override
	public boolean deleteGroup(int gId) {
		groupDao.deleteGroup(gId);
		return false;
	}

	@Override
	public Groups getById(int gId) {
		return groupDao.getById(gId);
	}

	@Override
	public List<Groups> getAllGroups() {
		return groupDao.getAllGroups();
	}
	
	@Override
	public List<User> getAllUsers(int gId){
		return groupDao.getAllUsers(gId);
	}
	
}
