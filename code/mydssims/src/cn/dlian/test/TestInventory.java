package cn.dlian.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.dlian.dao.DaoFactory;
import cn.dlian.dao.IInventoryDao;
import cn.dlian.entities.Inventory;

public class TestInventory {
	ApplicationContext context =new ClassPathXmlApplicationContext("applicationContext.xml");
	IInventoryDao invDao = ((DaoFactory)context.getBean("daoFactory")).getInvDao();
	
	@Test
	public void testQueryInventory() {
		List<Inventory> inventoies = invDao.queryInventory(1001, 1001, 1001);
		if(inventoies != null) {
			for (Inventory inventory : inventoies) {
				System.out.println(inventory.getMedicine());
				System.out.println(inventory.getSupplier());
				System.out.println(inventory.getCount());
			}
		}
	}
	
	@Test
	public void testUpdateInventory() {
		boolean bo = invDao.updateInventory(1001, 1001, 1001, -10);
		System.out.println(bo);
	}
	
	@Test
	public void testAddInventory() {
		boolean bo = invDao.addInventory(1001, 1001, 1001, 1000);
		System.out.println(bo);
	}
	
	@Test
	public void testDeleteInventory() {
		boolean bo = invDao.deleteInventory(1001, 1001, 1001);
		System.out.println(bo);
	}
	
}
