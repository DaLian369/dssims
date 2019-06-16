package cn.dlian.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import cn.dlian.dao.ICustomerDao;
import cn.dlian.dao.IInventoryDao;
import cn.dlian.dao.IMedicineDao;
import cn.dlian.dao.IOrderDao;
import cn.dlian.entities.Customer;
import cn.dlian.entities.Inventory;
import cn.dlian.entities.Medicine;
import cn.dlian.entities.Order;
import cn.dlian.entities.User;

@Transactional
public class CustomerServiceImpl implements ICustomerService {
	private ICustomerDao cusDao;
	private IMedicineDao medDao;
	private IOrderDao orderDao;
	private IInventoryDao invDao;
	
	public ICustomerDao getCusDao() {
		return cusDao;
	}

	public void setCusDao(ICustomerDao cusDao) {
		this.cusDao = cusDao;
	}

	public IMedicineDao getMedDao() {
		return medDao;
	}

	public void setMedDao(IMedicineDao medDao) {
		this.medDao = medDao;
	}

	public IOrderDao getOrderDao() {
		return orderDao;
	}

	public void setOrderDao(IOrderDao orderDao) {
		this.orderDao = orderDao;
	}

	public IInventoryDao getInvDao() {
		return invDao;
	}

	public void setInvDao(IInventoryDao invDao) {
		this.invDao = invDao;
	}

	/**
	 * 客户登陆
	 */
	@Override
	public User login(String phone, String password) {
		return cusDao.login(phone, password);
	}

	/**
	 * 客户修改密码
	 */
	@Override
	public boolean updatePassword(int id, String newPass) {
		return cusDao.updatePassword(id, newPass);
	}

	/**
	 * 客户注册
	 */
	@Override
	public boolean regist(Customer cus) {
		return cusDao.addCustomer(cus);
	}

	/**
	 * 客户信息查询
	 */
	@Override
	public Customer queryInfo(int id) {
		return cusDao.queryInfo(id);
	}

	/**
	 * 客户修改信息
	 */
	@Override
	public boolean updateInfo(Customer cus) {
		return cusDao.updateInfo(cus);
	}

	/**
	 * 下订单
	 */
	@Override
	public boolean placeOnOrder(Order order) {
		return orderDao.addOrder(order);
	}

	/**
	 * 付款
	 * 1.修改订单
	 * 2.减少库存(invDao)
	 * @throws Exception 
	 */
	@Override
	public boolean payment(int oid){
		//查询到订单信息
		Order order = orderDao.queryOrderByOid(oid);
		if(order!=null) {
			//1.付款
			orderDao.updateOrder(oid, 1);
			//2.减少库存
			invDao.updateInventory(order.getAid(), order.getMid(), order.getSid(), order.getQty()*(-1));
			return true;
		}
		return false;
	}

	/**
	 * 取消订单
	 */
	@Override
	public boolean cancleOrder(int oid) {
		return orderDao.deleteOrder(oid);
	}

	/**
	 * 精确查询药品
	 */
	@Override
	public List<Inventory> queryMedicine(Integer aid,Integer mid,Integer sid) {
		return invDao.queryInventory(aid, mid, sid);
	}

	/**
	 * 模糊查询
	 * 查询药品信息，通过返回的药品信息，查看出售的管理员及厂商
	 */
	@Override
	public List<Inventory> fuzzyQuery(String msg) {
		return invDao.fuzzyQuery(msg);
	}

	/**
	 * 查询客户所有订单
	 */
	@Override
	public List<Order> queryOrdersByCid(int cid) {
		return orderDao.queryOrdersByCid(cid);
	}

	/**
	 * 查询客户已付款订单
	 */
	@Override
	public List<Order> queryOrdersByCidPaid(int cid) {
		return orderDao.queryOrdersByCidPaid(cid);
	}

	/**
	 * 查询客户待付款订单
	 */
	@Override
	public List<Order> queryOrdersByCidWait(int cid) {
		return orderDao.queryOrdersByCidWait(cid);
	}

}
