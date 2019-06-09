package cn.dlian.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import cn.dlian.dao.DaoFactory;
import cn.dlian.dao.ICustomerDao;
import cn.dlian.dao.IInventoryDao;
import cn.dlian.dao.IOrderDao;
import cn.dlian.entities.Customer;
import cn.dlian.entities.Medicine;
import cn.dlian.entities.Order;

@Transactional
public class CustomerServiceImpl implements ICustomerService {
	private DaoFactory daoFactory;
	private ICustomerDao cusDao = daoFactory.getCusDao();
	private IOrderDao orderDao = daoFactory.getOrderDao();
	private IInventoryDao invDao = daoFactory.getInvDao();
	public DaoFactory getDaoFactory() {
		return daoFactory;
	}

	public void setDaoFactory(DaoFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	/**
	 * 客户登陆
	 */
	@Override
	public boolean login(String phone, String password) {
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
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * 付款
	 * 1.修改订单
	 * 2.减少库存(invDao)
	 */
	@Override
	public boolean payment(int oid) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * 取消订单
	 */
	@Override
	public boolean cancleOrder(int oid) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * 精确查询药品
	 */
	@Override
	public List<Medicine> queryMedicine(int aid, int mid, int sid) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 模糊查询
	 */
	@Override
	public List<Medicine> fuzzyQuery(String msg) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 查询客户所有订单
	 */
	@Override
	public List<Order> queryOrdersByCid(int cid) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 查询客户已付款订单
	 */
	@Override
	public List<Order> queryOrdersByCidPaid(int cid) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 查询客户待付款订单
	 */
	@Override
	public List<Order> queryOrdersByCidWait(int cid) {
		// TODO Auto-generated method stub
		return null;
	}

}
