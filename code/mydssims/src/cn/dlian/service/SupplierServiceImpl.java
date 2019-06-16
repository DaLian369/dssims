package cn.dlian.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import cn.dlian.dao.IPurchaseDao;
import cn.dlian.dao.ISupplierDao;
import cn.dlian.entities.Purchase;
import cn.dlian.entities.Supplier;
import cn.dlian.entities.User;

@Transactional
public class SupplierServiceImpl implements ISupplierService {

	private ISupplierDao supDao;
	private IPurchaseDao purDao;
	

	public ISupplierDao getSupDao() {
		return supDao;
	}

	public void setSupDao(ISupplierDao supDao) {
		this.supDao = supDao;
	}

	public IPurchaseDao getPurDao() {
		return purDao;
	}

	public void setPurDao(IPurchaseDao purDao) {
		this.purDao = purDao;
	}

	/**
	 * 供应商信息查询
	 */
	@Override
	public Supplier queryInfo(int id) {
		return supDao.queryInfo(id);
	}
	
	/**
	 * 供应商登陆
	 */
	@Override
	public User login(String phone, String password) {
		return supDao.login(phone, password);
	}

	/**
	 * 供应商修改密码
	 */
	@Override
	public boolean updatePassword(int id, String newPass) {
		return supDao.updatePassword(id, newPass);
	}

	/**
	 * 供应商注册
	 */
	@Override
	public boolean regist(Supplier sup) {
		return supDao.addSupplier(sup);
	}


	/**
	 * 供应商修改信息
	 */
	@Override
	public boolean updateInfo(Supplier sup) {
		return supDao.updateInfo(sup);
	}

	/**
	 * 查询供应商所有订单
	 */
	@Override
	public List<Purchase> queryPurchasesBySid(int sid) {
		return purDao.queryPurchasesBySid(sid);
	}

	/**
	 * 查询供应商已成交订单
	 */
	@Override
	public List<Purchase> queryPurchasesBySidPaid(int sid) {
		return purDao.queryPurchasesBySidPaid(sid);
	}

	/**
	 * 查询供应商待成交订单
	 */
	@Override
	public List<Purchase> queryPurchasesBySidWait(int sid) {
		return purDao.queryPurchasesBySidWait(sid);
	}

	/**
	 * 通过aid和mid查询采购单
	 */
	@Override
	public List<Purchase> queryPurchasesByThreeId(Integer sid, Integer mid,Integer aid) {
		return purDao.queryPurchasesByThreeId(sid,mid,aid);
	}

	

}
