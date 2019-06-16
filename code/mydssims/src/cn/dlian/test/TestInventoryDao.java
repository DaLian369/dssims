package cn.dlian.test;

import java.util.List;
import java.util.Random;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.dlian.dao.DaoFactory;
import cn.dlian.dao.IInventoryDao;
import cn.dlian.entities.Inventory;

public class TestInventoryDao {
	ApplicationContext context =new ClassPathXmlApplicationContext("applicationContext.xml");
	IInventoryDao invDao = ((DaoFactory)context.getBean("daoFactory")).getInvDao();
	
	@Test
	public void testAddInventory() {
		Random random = new Random();
		for(int i=1;i<1500;i++) {
			invDao.addInventory(random.nextInt(30)+1,random.nextInt(30)+1,random.nextInt(30)+1,random.nextInt(5000)+1);
		}
	}
	
	@Test
	public void testQueryInventory() {
		List<Inventory> inventoies = invDao.queryInventory(3, 1, 5);
		if(inventoies != null) {
			for (Inventory inventory : inventoies) {
				System.out.println(inventory);
			}
		}
	}
	
	@Test
	public void testUpdateInventory() {
		Random random = new Random();
		for(int i=1;i<1500;i++) {
			invDao.updateInventory(random.nextInt(30)+1,random.nextInt(30)+1,random.nextInt(30)+1,random.nextInt(5000)+1);
		}
	}
	
	@Test
	public void testQueryWillSellOut() {
		List<Inventory> invs = invDao.queryWillSellOut(1, 2000);
		for (Inventory inventory : invs) {
			System.out.println(inventory);
		}
	}
	
	@Test
	public void testDeleteInventory() {
		boolean bo = invDao.deleteInventory(1, 1, 1);
		System.out.println(bo);
	}
	
	@Test
	public void testFuzzyQuery() {
		List<Inventory> invs = invDao.fuzzyQuery("1");
		for (Inventory inventory : invs) {
			System.out.println(inventory);
		}
	}
}
