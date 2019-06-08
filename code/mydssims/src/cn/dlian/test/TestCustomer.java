package cn.dlian.test;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.dlian.dao.DaoFactory;
import cn.dlian.dao.ICustomerDao;
import cn.dlian.entities.Customer;
import cn.dlian.entities.Order;

public class TestCustomer {
	ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
	ICustomerDao cusDao = ((DaoFactory)context.getBean("daoFactory")).getCusDao();
	@Test
//	@Ignore
	public void testQueryInfo() {
		Customer cus = cusDao.queryInfo(1001);
		System.out.println(cus);
	}
	
	@Test
	public void testLogin() {
		boolean bo = cusDao.login(1001, "123456");
		System.out.println(bo);
	}
	
	@Test
//	@Ignore
	public void testRegist() {
		Customer cus = new Customer(1002,"赵铁柱","123456","18706729691");
		boolean bo = cusDao.regist(cus);
		System.out.println(bo);
	}
	
	@Test
//	@Ignore
	public void testUpdatePassword() {
		boolean bo = cusDao.updatePassword(1002, "123456");
		System.out.println(bo);
	}
	
	@Test
	public void testUpdateInfo() {
		Customer cus = new Customer(1002,"王强斌","","18706729611");
//		Customer cus = new Customer(1002,"赵铁柱","123456","18706729691");
		boolean bo = cusDao.updateInfo(cus);
		System.out.println(bo);
	}
}
