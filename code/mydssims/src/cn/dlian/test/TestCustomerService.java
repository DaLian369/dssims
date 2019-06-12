package cn.dlian.test;



import java.sql.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.dlian.entities.Customer;
import cn.dlian.entities.Medicine;
import cn.dlian.entities.Order;
import cn.dlian.service.ICustomerService;
import cn.dlian.service.ServiceFactory;

public class TestCustomerService {
	ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
	ICustomerService cusService = ((ServiceFactory)context.getBean("serviceFactory")).getCusService();
	@Test
	public void testQueryInfo() {
		Customer cus = cusService.queryInfo(1);
		System.out.println(cus);
	}
	
	@Test
	public void testLogin() {
		Customer cus = (Customer)cusService.login("18736729676", "123456");
		System.out.println(cus);
	}
	
	@Test
	public void testRegist() {
		Customer cus = new Customer("铁柱","123456","18706729691");
		boolean bo = cusService.regist(cus);
		System.out.println(bo);
	}
	
	@Test
	public void testUpdatePassword() {
		boolean bo = cusService.updatePassword(1, "123456");
		System.out.println(bo);
	}
	
	@Test
	public void testUpdateInfo() {
		Customer cus = new Customer("王强斌","","18706729611");
//		Customer cus = new Customer(1002,"赵铁柱","123456","18706729691");
		boolean bo = cusService.updateInfo(cus);
		System.out.println(bo);
	}
	
	@Test
	public void testPlaceOnOrder(){
		Order order = new Order(1,1,1,1,10,100,new Date(0),2);
		cusService.placeOnOrder(order);
	}
	
	@Test
	public void testPayment() {
		cusService.payment(4);
	}
	
	@Test
	public void testCancleOrder() {
		cusService.cancleOrder(4);
	}
	
	@Test
	public void testQueryMedicine() {
		Medicine med = cusService.queryMedicine(1);
		System.out.println(med);
	}
	
	@Test
	public void testFuzzyQuery() {
		List<Medicine> meds = cusService.fuzzyQuery("蓝");
		System.out.println(meds.get(0));
	}
	
	@Test
	public void testQueryOrdersByCid() {
		List<Order> orders = cusService.queryOrdersByCid(1);
		for (Order order : orders) {
			System.out.println(order);
		}
	}
	
	@Test
	public void testQueryOrdersByCidPaid() {
		List<Order> orders = cusService.queryOrdersByCidPaid(1);
		for (Order order : orders) {
			System.out.println(order);
		}
	}
	
	@Test
	public void testQueryOrdersByCidWait() {
		List<Order> orders = cusService.queryOrdersByCidWait(1);
		for (Order order : orders) {
			System.out.println(order);
		}
	}
}
