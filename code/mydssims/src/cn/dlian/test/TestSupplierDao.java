package cn.dlian.test;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.dlian.dao.DaoFactory;
import cn.dlian.dao.ICustomerDao;
import cn.dlian.dao.ISupplierDao;
import cn.dlian.entities.Customer;
import cn.dlian.entities.Supplier;


public class TestSupplierDao {
	ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
	ISupplierDao supDao = ((DaoFactory)context.getBean("daoFactory")).getSupDao();
	
	@Test
	public void testQueryInfo() {
		Supplier sup = supDao.queryInfo(1001);
		System.out.println(sup);
	}
	
	@Test
	public void testLogin() {
		Supplier sup = (Supplier)supDao.login("100001", "123456");
		System.out.println(sup);
	}
	
	@Test
	public void testAddSuppier() {
		for(int i=1;i<=30;i++) {
			Supplier sup = new Supplier("供应商"+i,"123456","10000"+i,"西安");
			supDao.addSupplier(sup);
		}
	}
	
	@Test
	public void testUpdatePassword() {
		boolean bo = supDao.updatePassword(1, "12345");
		System.out.println(bo);
	}
	
	@Test
	public void testUpdateInfo() {
		Supplier sup = new Supplier("王斌","","18706729611","西安");
//		Supplier sup = new Supplier(1002,"赵铁","123456","18706729691");
		boolean bo = supDao.updateInfo(sup);
		System.out.println(bo);
	}
}
