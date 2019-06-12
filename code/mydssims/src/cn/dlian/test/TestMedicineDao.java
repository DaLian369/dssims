package cn.dlian.test;


import java.sql.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.dlian.dao.DaoFactory;
import cn.dlian.dao.IMedicineDao;
import cn.dlian.entities.Medicine;

public class TestMedicineDao {
	ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
	IMedicineDao medDao = ((DaoFactory) context.getBean("daoFactory")).getMedDao();
	
	@Test
	public void testAddMedicine() {
		
		Date date = new Date(new java.util.Date().getTime());
		Medicine med = new Medicine("钙片","补钙",10,date,"6个月");
		boolean bo = medDao.addMedicine(med);
		System.out.println(bo);
	}
	
	@Test
	public void testDeleteMedicine() {
		boolean bo = medDao.deleteMedicine(1002);
		System.out.println(bo);
	}
	@Test
	public void testUpdateMedicine() {
		Date date = new Date(new java.util.Date().getTime());
		Medicine med = new Medicine("板根","预防感冒",10,date,"7个月");
		med.setId(1);
		boolean bo = medDao.updateMedicine(med);
		System.out.println(bo);
	}
	
	@Test
	public void testQueryMedicine() {
		Medicine med = medDao.queryMedicine(1);
		System.out.println(med);
	}
	
	@Test
	public void testFuzzyQuery() {
		List<Medicine> meds = medDao.fuzzyQuery("蓝");
		for (Medicine medicine : meds) {
			System.out.println(medicine);
		}
	}
	
}
