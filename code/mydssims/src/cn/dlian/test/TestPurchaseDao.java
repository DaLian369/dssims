package cn.dlian.test;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.dlian.dao.DaoFactory;
import cn.dlian.dao.IPurchaseDao;
import cn.dlian.entities.Purchase;

public class TestPurchaseDao {
	ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
	IPurchaseDao purDao = ((DaoFactory)context.getBean("daoFactory")).getPurDao();
	
	@Test
	public void addPurchase() {
		Purchase purchase = new Purchase( 1, 1, 1, 10, 100, new Date(new java.util.Date().getTime()), 1);
		boolean bo= purDao.addPurchase(purchase);
		System.out.println(bo);
	}
	
	@Test
	public void updatePurchase() {
		boolean bo = purDao.updatePurchase(1, 2);
		System.out.println(bo);
	}
	
	@Test
	public void deletePurchase() {
		boolean bo = purDao.deletePurchase(1);
		System.out.println(bo);
	}
	
	@Test
	public void queryPurchasesByAid(){
		List<Purchase> purchases = purDao.queryPurchasesByAid(1);
		for (Purchase purchase : purchases) {
			System.out.println(purchase);
		}
	}
	
	@Test
	public void queryPurchasesByAidPaid() {
		List<Purchase> purchases = purDao.queryPurchasesByAidPaid(1);
		for (Purchase purchase : purchases) {
			System.out.println(purchase);
		}
	}
	
	@Test
	public void queryPurchasesByAidWait() {
		List<Purchase> purchases = purDao.queryPurchasesByAidWait(1);
		for (Purchase purchase : purchases) {
			System.out.println(purchase);
		}
	}
	
	@Test
	public void queryPurchaseByPid() {
		Purchase purchase = purDao.queryPurchaseByPid(1);
		System.out.println(purchase);
	}
	
	@Test
	public void queryPurchasesBySid() {
		List<Purchase> purchases = purDao.queryPurchasesBySid(1);
		for (Purchase purchase : purchases) {
			System.out.println(purchase);
		}
	}
	
	@Test
	public void queryPurchasesBySidPaid() {
		List<Purchase> purchases = purDao.queryPurchasesBySidPaid(1);
		for (Purchase purchase : purchases) {
			System.out.println(purchase);
		}
	}
	
	@Test
	public void queryPurchasesBySidWait() {
		List<Purchase> purchases = purDao.queryPurchasesBySidWait(1);
		for (Purchase purchase : purchases) {
			System.out.println(purchase);
		}
	}
	
	@Test
	public void queryPurchasesBySidAid() {
		List<Purchase> purchases = purDao.queryPurchasesBySidAid(1, 1);
		for (Purchase purchase : purchases) {
			System.out.println(purchase);
		}
	}
	
}
