package cn.dlian.test;


import java.sql.Date;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.dlian.dao.DaoFactory;
import cn.dlian.dao.IAdministratorDao;
import cn.dlian.entities.Administrator;
import cn.dlian.entities.Medicine;

public class TestAdministratorDao {
	ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
	IAdministratorDao admDao = ((DaoFactory) context.getBean("daoFactory")).getAdmDao();
	@Test
	public void testQueryInfo() {
		Administrator adm = admDao.queryInfo(1);
		System.out.println(adm);
	}
	
	@Test
	public void testLogin() {
		Administrator adm = (Administrator)admDao.login("18706729677", "123455");
		System.out.println(adm.getLimit());
	}

	@Test
	public void testAddCustomer() {
		for(int i=1;i<=30;i++) {
			Administrator adm = new Administrator("管理员"+i,"123456","10000"+i);
			boolean bo = admDao.addAdministrator(adm);
		}
	}
	
	@Test
	public void testUpdatePassword() {
		boolean bo = admDao.updatePassword(1, "123455");
		System.out.println(bo);
	}
	
	@Test
	public void testUpdateInfo() {
		Administrator adm = new Administrator("王强斌","","1870629692");
//		Administrator adm = new Administrator(1002,"赵铁柱","123456","18706729691");
		boolean bo = admDao.updateInfo(adm);
		System.out.println(bo);
	}
	
}
