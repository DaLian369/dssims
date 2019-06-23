package cn.dlian.test;

import java.sql.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.dlian.entities.Administrator;
import cn.dlian.entities.Inventory;
import cn.dlian.entities.Medicine;
import cn.dlian.entities.Order;
import cn.dlian.entities.Purchase;
import cn.dlian.service.IAdministratorService;
import cn.dlian.service.ServiceFactory;

public class TestAdministratorService {
	ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
	IAdministratorService admService = ((ServiceFactory)context.getBean("serviceFactory")).getAdmService();
	
	@Test
//	@Ignore
	public void testQueryInfo() {
		Administrator adm = admService.queryInfo(1);
		System.out.println(adm);
	}
	
	@Test
	public void testLogin() {
		Administrator adm = (Administrator)admService.login("18706729677", "123456");
		System.out.println(adm);
	}

	@Test
//	@Ignore
	public void testAddCustomer() {
		Administrator adm = new Administrator("赵","123456","1870629692");
		boolean bo = admService.regist(adm);
		System.out.println(bo);
	}
	
	@Test
//	@Ignore
	public void testUpdatePassword() {
		boolean bo = admService.updatePassword(1, "123455");
		System.out.println(bo);
	}
	
	@Test
	public void testUpdateInfo() {
		Administrator adm = new Administrator("王强斌","","18706729611");
//		Administrator adm = new Administrator(1002,"赵铁柱","123456","18706729691");
		boolean bo = admService.updateInfo(adm);
		System.out.println(bo);
	}
	
	@Test
	public void testAddMedicine() {
		Medicine med = new Medicine("六神花露水","香香",10,new Date(new java.util.Date().getTime()),"1年");
		admService.addMedicine(med);
	}
	/*
	@Test
	public void testQueryMedicine() {
		System.out.println(admService.queryMedicine(3));
	}
	
	@Test
	public void testFuzzyQuery() {
		System.out.println(admService.fuzzyQuery("香"));
	}
	
	@Test
	public void testQueryOrdersByAid() {
		List<Order> orders = admService.queryOrdersByAid(1);
		for (Order order : orders) {
			System.out.println(order);
		}
	}*/
	
	@Test
	public void testQueryOrdersByAidPaid() {
		List<Order> orders = admService.queryOrdersByAidPaid(1);
		for (Order order : orders) {
			System.out.println(order);
		}
	}
	
	@Test
	public void testQueryOrdersByAidWait() {
		List<Order> orders = admService.queryOrdersByAidWait(1);
		for (Order order : orders) {
			System.out.println(order);
		}
	}
	/*
	@Test
	public void testQueryOrderByOid() {
		Order order = admService.queryOrderByOid(2);
		System.out.println(order);
	}
	
	@Test
	public void testQueryPurchasesByAid() {
		List<Purchase> purs = admService.queryPurchasesByAid(1);
		for (Purchase purchase : purs) {
			System.out.println(purchase);
		}
	}
	*/
	@Test
	public void testQueryPurchasesByAidPaid() {
		List<Purchase> purs = admService.queryPurchasesByAidPaid(1);
		for (Purchase purchase : purs) {
			System.out.println(purchase);
		}
	}
	
	@Test
	public void testQueryPurchasesByAidWait() {
		List<Purchase> purs = admService.queryPurchasesByAidWait(1);
		for (Purchase purchase : purs) {
			System.out.println(purchase);
		}
	}
	/*
	@Test
	public void testQueryPurchaseByPid() {
		Purchase pur = admService.queryPurchaseByPid(1);
		System.out.println(pur);
	}*/
	
	@Test
	public void testQueryInventory() {
		List<Inventory> invs = admService.queryInventory(1, 1, 1);
		for (Inventory inventory : invs) {
			System.out.println(inventory);
		}
	}
	
	@Test
	public void testPlaceOnPurchase() {
		Purchase pur = new Purchase(1,1,1,10,100,new Date(new java.util.Date().getTime()),2);
		boolean bo = admService.placeOnPurchase(pur);
		System.out.println(bo);
	}
	
	@Test
	public void testPayment() {
		boolean bo = admService.payment(2);
		System.out.println(bo);
	}
	
	@Test
	public void testCanclePurchase() {
		boolean bo = admService.canclePurchase(2);
		System.out.println(bo);
	}
}
