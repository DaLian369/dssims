package cn.dlian.dao;

import java.util.List;

import cn.dlian.entities.Order;

public interface IOrderDao {
	//List<Order> queryOrdersByCid(int cid);
	List<Order> queryOrdersByCidPaid(int cid);
	List<Order> queryOrdersByCidWait(int cid);
	Order queryOrderByOid(int oid);
	//List<Order> queryOrdersByAid(int aid);
	List<Order> queryOrdersByAidPaid(int aid);
	List<Order> queryOrdersByAidWait(int aid);
	//List<Order> queryOrdersByAidCid(int aid,int cid);
	boolean addOrder(Order order);
	boolean updateOrder(int oid,int state);
	boolean deleteOrder(int oid);
	
	List<Order> queryOrdersByOidAidCid(Integer oid,Integer aid,Integer cid);
}
