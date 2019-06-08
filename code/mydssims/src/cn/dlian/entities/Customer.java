package cn.dlian.entities;

import java.util.List;

/*
 * 客户类
 */
public class Customer extends User {
	private List<Order> orders;
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customer(int id, String name, String password, String phone) {
		super(id, name, password, phone);
		// TODO Auto-generated constructor stub
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	
} 
