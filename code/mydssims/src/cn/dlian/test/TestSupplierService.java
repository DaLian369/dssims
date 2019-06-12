package cn.dlian.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.dlian.entities.Purchase;
import cn.dlian.entities.Supplier;
import cn.dlian.service.ISupplierService;
import cn.dlian.service.ServiceFactory;

public class TestSupplierService {
	ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
	ISupplierService supService = ((ServiceFactory)context.getBean("serviceFactory")).getSupService();
	
	@Test
	public void testQueryInfo() {
		Supplier sup = supService.queryInfo(1001);
		System.out.println(sup);
	}
	
	@Test
	public void testLogin() {
		Supplier sup = (Supplier)supService.login("18702729676", "123456");
		System.out.println(sup);
	}
	
	@Test
	public void testAddSuppier() {
		Supplier sup = new Supplier("赵柱","123456","18706729671","西安");
		boolean bo = supService.regist(sup);
		System.out.println(bo);
	}
	
	@Test
	public void testUpdatePassword() {
		boolean bo = supService.updatePassword(1, "12345");
		System.out.println(bo);
	}
	
	@Test
	public void testUpdateInfo() {
		Supplier sup = new Supplier("王斌","","18706729611","西安");
//		Supplier sup = new Supplier(1002,"赵铁","123456","18706729691");
		boolean bo = supService.updateInfo(sup);
		System.out.println(bo);
	}
	
	@Test
	public void testQueryPurchasesBySid() {
		List<Purchase> purs = supService.queryPurchasesBySid(1);
		for (Purchase purchase : purs) {
			System.out.println(purchase);
		}
	}
	
	@Test
	public void testQueryPurchasesBySidPaid() {
		List<Purchase> purs = supService.queryPurchasesBySidPaid(1);
		for (Purchase purchase : purs) {
			System.out.println(purchase);
		}
	}
	
	@Test
	public void testQueryPurchasesBySidWait() {
		List<Purchase> purs = supService.queryPurchasesBySidWait(1);
		for (Purchase purchase : purs) {
			System.out.println(purchase);
		}
	}
}
