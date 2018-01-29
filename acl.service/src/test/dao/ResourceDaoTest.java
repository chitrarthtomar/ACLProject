package dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;

import model.Resource;

public class ResourceDaoTest {


	ResourceDao resourceDao = new ResourceDaoImpl();
	

	@Test
	public void is_createResource_Working_with_delete () throws Exception{
		boolean test = resourceDao.createResource("abc", "Hello");
		assertEquals(true, test);
		List<Resource> list = resourceDao.getAllResources();
		assertEquals("abc", list.get(list.size()-1).getrName());
		test = resourceDao.deleteResource(list.get(list.size()-1).getrId());
		assertEquals(true, test);
	}
	
	@Test
	public void is_delete_empty_Resource_Working () throws Exception{
		boolean test = resourceDao.deleteResource(3253253);
		assertEquals(false, test);
	}
	
	@Test
	public void is_getAllResource_Working () throws Exception{
		List<Resource> list = resourceDao.getAllResources();
		assertNotNull(list);
		assertNotEquals(list.size(), 0);
	}
	
	@Test
	public void is_getResourceById_working () throws Exception{
		boolean test = resourceDao.createResource("abc", "Hello");
		assertEquals(true, test);
		List<Resource> list = resourceDao.getAllResources();
		Resource r = resourceDao.getById(list.get(list.size()-1).getrId());
		assertEquals(r.getrName(), list.get(list.size()-1).getrName());
		test = resourceDao.deleteResource(list.get(list.size()-1).getrId());
		assertEquals(true, test);
	}
	
	@Test
	public void is_updateResource_Working_with_delete () throws Exception{
		boolean test = resourceDao.createResource("abc", "Hello");
		assertEquals(true, test);
		List<Resource> list = resourceDao.getAllResources();
		int rId=list.get(list.size()-1).getrId();
		boolean isupdated = resourceDao.updateResource(rId, "hey", "hello");
		assertEquals(true, isupdated);
		Resource resource = resourceDao.getById(rId);
		assertEquals("hey", resource.getrName());
		test = resourceDao.deleteResource(rId);
		assertEquals(true, test);
	}
	
}
