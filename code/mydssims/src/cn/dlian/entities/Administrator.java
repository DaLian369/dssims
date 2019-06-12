package cn.dlian.entities;

import java.util.List;
import java.util.Map;

/*
 * 管理员/药铺类
 */
public class Administrator extends User {
	private int limit;
	private List<Order> orders;
	private List<Purchase> purchases;
	private List<Inventory> inventories;
	
	
	public Administrator() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Administrator(String name, String password, String phone) {
		super(name, password, phone);
		limit = 20;
		// TODO Auto-generated constructor stub
	}
	
	public int getLimit() {
		return limit;
	}
	public void setLimit(int limit) {
		this.limit = limit;
	}
	public List<Order> getOrders() {
		return orders;
	}
	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	public List<Purchase> getPurchases() {
		return purchases;
	}
	public void setPurchases(List<Purchase> purchases) {
		this.purchases = purchases;
	}
	public List<Inventory> getInventories() {
		return inventories;
	}
	public void setInventories(List<Inventory> inventories) {
		this.inventories = inventories;
	}
	
	
	
}
