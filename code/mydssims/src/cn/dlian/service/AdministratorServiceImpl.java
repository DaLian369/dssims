package cn.dlian.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import cn.dlian.dao.DaoFactory;
import cn.dlian.dao.IAdministratorDao;
import cn.dlian.dao.IInventoryDao;
import cn.dlian.dao.IOrderDao;
import cn.dlian.dao.IPurchaseDao;
import cn.dlian.entities.Administrator;
import cn.dlian.entities.Inventory;
import cn.dlian.entities.Medicine;
import cn.dlian.entities.Order;
import cn.dlian.entities.Purchase;

@Transactional
public class AdministratorServiceImpl implements IAdministratorService{
	private DaoFactory daoFactory;
	private IAdministratorDao admDao = daoFactory.getAdmDao();
	private IInventoryDao invDao = daoFactory.getInvDao();
	private IOrderDao orderDao = daoFactory.getOrderDao();
	private IPurchaseDao purDao = daoFactory.getPurDao();

	public DaoFactory getDaoFactory() {
		return daoFactory;
	}

	public void setDaoFactory(DaoFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	/**
	 * 查询个人信息
	 */
	@Override
	public Administrator queryInfo(int id) {
		return admDao.queryInfo(id);
	}

	/**
	 * 注册
	 */
	@Override
	public boolean regist(Administrator adm) {
		return admDao.addAdministrator(adm);
	}

	/**
	 * 修改个人信息
	 */
	@Override
	public boolean updateInfo(Administrator adm) {
		return admDao.updateInfo(adm);
	}

	/**
	 * 登陆
	 */
	@Override
	public boolean login(String phone, String password) {
		return admDao.login(phone, password);
	}

	/**
	 * 修改密码
	 */
	@Override
	public boolean updatePassword(int id, String newPass) {
		return admDao.updatePassword(id, newPass);
	}

	/**
	 * 发布药品信息
	 * 1.添加药品信息(medDao)
	 * 2.添加库存(invDao)
	 */
	@Override
	public boolean addMedicine(Medicine med) {
		// TODO Auto-generated method stub
		return false;
	}
	
	/**
	 * 删除药品信息
	 * (只是删除自己的库存,并不会删除该药品的信息)
	 * (也就是说，Medicine里的药品信息只会多不会少
	 */
	@Override
	public boolean deleteMedicine(int mid) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * 修改药品信息
	 */
	@Override
	public boolean updateMedicine(Medicine mmed) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * 查询药品
	 */
	@Override
	public Medicine queryMedicine(int mid) {
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
	 * 查询管理员所有订单
	 */
	@Override
	public List<Order> queryOrdersByAid(int aid) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 查询管理员已成交订单
	 */
	@Override
	public List<Order> queryOrdersByAidPaid(int aid) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 查询管理员待成交订单
	 */
	@Override
	public List<Order> queryOrdersByAidWait(int aid) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 查询管理员和某一客户相关的订单
	 */
	@Override
	public List<Order> queryOrdersByAidCid(int aid, int cid) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 通过订单号查询
	 */
	@Override
	public Order queryOrderByOid(int oid) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 查询管理员所有采购单
	 */
	@Override
	public List<Purchase> queryPurchasesByAid(int aid) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 查询管理员已付款采购单
	 */
	@Override
	public List<Purchase> queryPurchasesByAidPaid(int aid) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 查询管理员待付款采购单
	 */
	@Override
	public List<Purchase> queryPurchasesByAidWait(int aid) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 查询管理员和某一供应商相关的采购单
	 */
	@Override
	public List<Purchase> queryPurchasesBySidAid(int sid, int aid) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 通过采购单号查询
	 */
	@Override
	public Purchase queryPurchaseByPid(int pid) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 查询库存信息
	 */
	@Override
	public List<Inventory> queryInventory(int aid, int mid, int sid) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 下采购单
	 */
	@Override
	public boolean placeOnPurcahse(Purchase pur) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * 付款
	 * 1.修改采购单
	 * 2.(若是自家新药品)发布药品信息
	 * 3.(若不是自家新药品)直接添加库存
	 */
	@Override
	public boolean payment(int pid) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * 取消采购单
	 */
	@Override
	public boolean canclePurchase(int pid) {
		// TODO Auto-generated method stub
		return false;
	}
}
