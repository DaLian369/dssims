package cn.dlian.service;

import java.util.List;

import cn.dlian.entities.Customer;
import cn.dlian.entities.Medicine;
import cn.dlian.entities.Order;

public interface ICustomerService extends IUserService {
	boolean regist(Customer cus);
	Customer queryInfo(int id);
	boolean updateInfo(Customer cus);
	boolean placeOnOrder(Order order);
	boolean payment(int oid);
	boolean cancleOrder(int oid);
	Medicine queryMedicine(int mid);
	List<Medicine> fuzzyQuery(String msg);
	List<Order> queryOrdersByCid(int cid);
	List<Order> queryOrdersByCidPaid(int cid);
	List<Order> queryOrdersByCidWait(int cid);
} 
