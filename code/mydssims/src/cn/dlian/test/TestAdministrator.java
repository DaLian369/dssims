package cn.dlian.test;


import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.dlian.dao.DaoFactory;
import cn.dlian.dao.IAdministratorDao;
import cn.dlian.entities.Administrator;
import cn.dlian.entities.Customer;

public class TestAdministrator {
	ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
	IAdministratorDao admDao = ((DaoFactory) context.getBean("daoFactory")).getAdmDao();
	@Test
//	@Ignore
	public void testQueryInfo() {
		Administrator adm = admDao.queryInfo(1001);
		System.out.println(adm);
	}
	
	@Test
	public void testLogin() {
		boolean bo = admDao.login(1001, "123456");
		System.out.println(bo);
	}

	@Test
//	@Ignore
	public void testRegist() {
		Administrator adm = new Administrator(1002,"赵铁","123456","18706729692");
		boolean bo = admDao.regist(adm);
		System.out.println(bo);
	}
	
	@Test
//	@Ignore
	public void testUpdatePassword() {
		boolean bo = admDao.updatePassword(1002, "123455");
		System.out.println(bo);
	}
	
	@Test
	public void testUpdateInfo() {
		Administrator adm = new Administrator(1002,"王强斌","","18706729611");
//		Administrator adm = new Administrator(1002,"赵铁柱","123456","18706729691");
		boolean bo = admDao.updateInfo(adm);
		System.out.println(bo);
	}
	
}
