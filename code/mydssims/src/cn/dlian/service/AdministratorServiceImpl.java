package cn.dlian.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import cn.dlian.dao.IAdministratorDao;
import cn.dlian.dao.IInventoryDao;
import cn.dlian.dao.IMedicineDao;
import cn.dlian.dao.IOrderDao;
import cn.dlian.dao.IPurchaseDao;
import cn.dlian.entities.Administrator;
import cn.dlian.entities.Inventory;
import cn.dlian.entities.Medicine;
import cn.dlian.entities.Order;
import cn.dlian.entities.Purchase;
import cn.dlian.entities.User;

@Transactional
public class AdministratorServiceImpl implements IAdministratorService{
	private IAdministratorDao admDao;
	private IMedicineDao medDao;
	private IInventoryDao invDao;
	private IOrderDao orderDao;
	private IPurchaseDao purDao;
	public IAdministratorDao getAdmDao() {
		return admDao;
	}

	public void setAdmDao(IAdministratorDao admDao) {
		this.admDao = admDao;
	}

	public IMedicineDao getMedDao() {
		return medDao;
	}

	public void setMedDao(IMedicineDao medDao) {
		this.medDao = medDao;
	}

	public IInventoryDao getInvDao() {
		return invDao;
	}

	public void setInvDao(IInventoryDao invDao) {
		this.invDao = invDao;
	}

	public IOrderDao getOrderDao() {
		return orderDao;
	}

	public void setOrderDao(IOrderDao orderDao) {
		this.orderDao = orderDao;
	}

	public IPurchaseDao getPurDao() {
		return purDao;
	}

	public void setPurDao(IPurchaseDao purDao) {
		this.purDao = purDao;
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
	public User login(String phone, String password) {
		return admDao.login(phone, password);
	}

	/**
	 * 修改密码
	 * 在js里先判断密码格式
	 * 在controller里判断密码是否和cookie里的值相同
	 * 在service力直接修改密码
	 */
	@Override
	public boolean updatePassword(int id,String newPass) {
		return admDao.updatePassword(id, newPass);
	}

	/**
	 * 发布药品信息
	 * 1.添加药品信息(medDao)
	 * 2.添加库存(invDao)
	 */
	@Override
	public boolean addMedicine(Medicine med) {
		return medDao.addMedicine(med);
	}
	
	/**
	 * 删除药品信息
	 * (只是删除自己的库存,并不会删除该药品的信息)
	 * (也就是说，Medicine里的药品信息只会多不会少
	 */
	@Override
	public boolean deleteInventory(int aid,int mid,int sid) {
		return invDao.deleteInventory(aid, mid, sid);
	}

	/**
	 * 修改药品信息
	 */
	@Override
	public boolean updateMedicine(Medicine med) {
		return medDao.updateMedicine(med);
	}

	/**
	 * 查询药品
	 */
	@Override
	public Medicine queryMedicine(int mid) {
		return medDao.queryMedicine(mid);
	}

	/**
	 * 模糊查询
	 */
	@Override
	public List<Medicine> fuzzyQuery(String msg) {
		return medDao.fuzzyQuery(msg);
	}

	/**
	 * 查询管理员所有订单
	 */
	@Override
	public List<Order> queryOrdersByAid(int aid) {
		return orderDao.queryOrdersByAid(aid);
	}

	/**
	 * 查询管理员已成交订单
	 */
	@Override
	public List<Order> queryOrdersByAidPaid(int aid) {
		return orderDao.queryOrdersByAidPaid(aid);
	}

	/**
	 * 查询管理员待成交订单
	 */
	@Override
	public List<Order> queryOrdersByAidWait(int aid) {
		return orderDao.queryOrdersByAidWait(aid);
	}

	/**
	 * 查询管理员和某一客户相关的订单
	 */
	@Override
	public List<Order> queryOrdersByAidCid(int aid, int cid) {
		return orderDao.queryOrdersByAidCid(aid, cid);
	}

	/**
	 * 通过订单号查询
	 */
	@Override
	public Order queryOrderByOid(int oid) {
		return orderDao.queryOrderByOid(oid);
	}

	/**
	 * 查询管理员所有采购单
	 */
	@Override
	public List<Purchase> queryPurchasesByAid(int aid) {
		return purDao.queryPurchasesByAid(aid);
	}

	/**
	 * 查询管理员已付款采购单
	 */
	@Override
	public List<Purchase> queryPurchasesByAidPaid(int aid) {
		return purDao.queryPurchasesByAidPaid(aid);
	}

	/**
	 * 查询管理员待付款采购单
	 */
	@Override
	public List<Purchase> queryPurchasesByAidWait(int aid) {
		return purDao.queryPurchasesByAidWait(aid);
	}

	/**
	 * 查询管理员和某一供应商相关的采购单
	 */
	@Override
	public List<Purchase> queryPurchasesByThreeId(Integer sid, Integer mid,Integer aid) {
		return purDao.queryPurchasesByThreeId(sid,mid,aid);
	}

	/**
	 * 通过采购单号查询
	 */
	@Override
	public Purchase queryPurchaseByPid(int pid) {
		return purDao.queryPurchaseByPid(pid);
	}

	/**
	 * 查询库存信息
	 */
	@Override
	public List<Inventory> queryInventory(int aid, int mid, int sid) {
		return invDao.queryInventory(aid, mid, sid);
	}

	/**
	 * 下采购单
	 */
	@Override
	public boolean placeOnPurchase(Purchase pur) {
		return purDao.addPurchase(pur);
	}

	/**
	 * 付款
	 * 1.修改采购单
	 * 2.若不是自家新药品,直接更新库存
	 * 3.若是自家新药品，需要添加库存信息
	 */
	@Override
	public boolean payment(int pid) {
		Purchase pur = purDao.queryPurchaseByPid(pid);
		purDao.updatePurchase(pid, 1);
		List<Inventory> invs = invDao.queryInventory(pur.getAid(), pur.getMid(), pur.getSid());
		boolean bo =false;
		if(invs.size()!=0&&invs.get(0).getCount()>=pur.getQty()) {
			invDao.updateInventory(pur.getAid(), pur.getMid(), pur.getSid(), pur.getQty());
			bo = true;
		}else if(invs.size()==0) {
			invDao.addInventory(pur.getAid(), pur.getMid(), pur.getSid(), pur.getQty());
			bo = true;
		}
		return bo;
	}

	/**
	 * 取消采购单
	 */
	@Override
	public boolean canclePurchase(int pid) {
		return purDao.deletePurchase(pid);
	}
}
