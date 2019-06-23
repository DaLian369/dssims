package cn.dlian.test;

import java.sql.Date;
import java.util.List;
import java.util.Random;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.dlian.dao.DaoFactory;
import cn.dlian.dao.IOrderDao;
import cn.dlian.entities.Order;

public class TestOrderDao {
	ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
	IOrderDao orderDao = ((DaoFactory)context.getBean("daoFactory")).getOrderDao();
	
	@Test
	public void addOrder() {
		Random random = new Random();
		for(int i=1;i<=1000;i++) {
			Order order = new Order( random.nextInt(30)+1, random.nextInt(30)+1, random.nextInt(30)+1, random.nextInt(30)+1, 10, 100, new Date(new java.util.Date().getTime()), 2);
			orderDao.addOrder(order);
		}
		
	}
	
	@Test
	public void updateOrder() {
		boolean bo = orderDao.updateOrder(1, 2);
		System.out.println(bo);
	}
	
	@Test
	public void deleteOrder() {
		boolean bo = orderDao.deleteOrder(1);
		System.out.println(bo);
	}
	/*
	@Test
	public void queryOrdersByCid(){
		List<Order> orders = orderDao.queryOrdersByCid(1);
		for (Order order : orders) {
			System.out.println(order);
		}
	}
	*/
	@Test
	public void queryOrdersByCidPaid() {
		List<Order> orders = orderDao.queryOrdersByCidPaid(1);
		for (Order order : orders) {
			System.out.println(order);
		}
	}
	
	@Test
	public void queryOrdersByCidWait() {
		List<Order> orders = orderDao.queryOrdersByCidWait(1);
		for (Order order : orders) {
			System.out.println(order);
		}
	}
	
	@Test
	public void queryOrderByOid() {
		Order order = orderDao.queryOrderByOid(1);
		System.out.println(order);
	}
	/*
	@Test
	public void queryOrdersByAid() {
		List<Order> orders = orderDao.queryOrdersByAid(1);
		for (Order order : orders) {
			System.out.println(order);
		}
	}
	*/
	@Test
	public void queryOrdersByAidPaid() {
		List<Order> orders = orderDao.queryOrdersByAidPaid(1);
		for (Order order : orders) {
			System.out.println(order);
		}
	}
	
	@Test
	public void queryOrdersByAidWait() {
		List<Order> orders = orderDao.queryOrdersByAidWait(1);
		for (Order order : orders) {
			System.out.println(order);
		}
	}
	/*
	@Test
	public void queryOrdersByAidCid() {
		List<Order> orders = orderDao.queryOrdersByAidCid(1,1);
		for (Order order : orders) {
			System.out.println(order);
		}
	}
	*/
}
