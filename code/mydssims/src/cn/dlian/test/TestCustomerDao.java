package cn.dlian.test;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.dlian.dao.DaoFactory;
import cn.dlian.dao.ICustomerDao;
import cn.dlian.entities.Customer;
import cn.dlian.entities.Order;

public class TestCustomerDao {
	ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
	ICustomerDao cusDao = ((DaoFactory)context.getBean("daoFactory")).getCusDao();
	@Test
	public void testQueryInfo() {
		Customer cus = cusDao.queryInfo(1);
		System.out.println(cus);
	}
	
	@Test
	public void testLogin() {
		Customer cus = (Customer)cusDao.login("18736729676", "123456");
		System.out.println(cus);
	}
	
	@Test
	public void testRegist() {
		Customer cus = new Customer("铁柱","123456","18706729691");
		boolean bo = cusDao.addCustomer(cus);
		System.out.println(bo);
	}
	
	@Test
	public void testUpdatePassword() {
		boolean bo = cusDao.updatePassword(1, "123456");
		System.out.println(bo);
	}
	
	@Test
	public void testUpdateInfo() {
		Customer cus = new Customer();
		cus.setId(1);
		cus.setName("xuelei");
//		Customer cus = new Customer(1002,"赵铁柱","123456","18706729691");
		boolean bo = cusDao.updateInfo(cus);
		System.out.println(bo);
	}
}
