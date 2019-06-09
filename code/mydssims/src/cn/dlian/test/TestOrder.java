package cn.dlian.test;

import java.sql.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.dlian.dao.DaoFactory;
import cn.dlian.dao.IOrderDao;
import cn.dlian.entities.Order;

public class TestOrder {
	ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
	IOrderDao orderDao = ((DaoFactory)context.getBean("daoFactory")).getOrderDao();
	
	@Test
	public void addOrder() {
		Order order = new Order(1, 1, 1, 1, 1, 10, 100, new Date(new java.util.Date().getTime()), 1);
		boolean bo= orderDao.addOrder(order);
		System.out.println(bo);
	}
	
	@Test
	public void updateOrder() {
		boolean bo = orderDao.updateOrder(1001, 2);
		System.out.println(bo);
	}
	
	@Test
	public void deleteOrder() {
		boolean bo = orderDao.deleteOrder(1001);
		System.out.println(bo);
	}
	
	@Test
	public void queryOrdersByCid(){
		List<Order> orders = orderDao.queryOrdersByCid(1001);
		for (Order order : orders) {
			System.out.println(order);
		}
	}
	
	@Test
	public void queryOrdersByCidPaid() {
		List<Order> orders = orderDao.queryOrdersByCidPaid(1001);
		for (Order order : orders) {
			System.out.println(order);
		}
	}
	
	@Test
	public void queryOrdersByCidWait() {
		List<Order> orders = orderDao.queryOrdersByCidWait(1001);
		for (Order order : orders) {
			System.out.println(order);
		}
	}
	
	@Test
	public void queryOrderByOid() {
		Order order = orderDao.queryOrderByOid(1001);
		System.out.println(order);
	}
	
	@Test
	public void queryOrdersByAid() {
		List<Order> orders = orderDao.queryOrdersByAid(1001);
		for (Order order : orders) {
			System.out.println(order);
		}
	}
	
	@Test
	public void queryOrdersByAidPaid() {
		List<Order> orders = orderDao.queryOrdersByAidPaid(1001);
		for (Order order : orders) {
			System.out.println(order);
		}
	}
	
	@Test
	public void queryOrdersByAidWait() {
		List<Order> orders = orderDao.queryOrdersByAidWait(1001);
		for (Order order : orders) {
			System.out.println(order);
		}
	}
	
	@Test
	public void queryOrdersByAidCid() {
		List<Order> orders = orderDao.queryOrdersByAidCid(1001,1001);
		for (Order order : orders) {
			System.out.println(order);
		}
	}
	
}
