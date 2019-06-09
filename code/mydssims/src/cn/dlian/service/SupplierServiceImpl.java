package cn.dlian.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import cn.dlian.dao.DaoFactory;
import cn.dlian.dao.IInventoryDao;
import cn.dlian.dao.IOrderDao;
import cn.dlian.dao.IPurchaseDao;
import cn.dlian.dao.ISupplierDao;
import cn.dlian.entities.Purchase;
import cn.dlian.entities.Supplier;

@Transactional
public class SupplierServiceImpl implements ISupplierService {

	private DaoFactory daoFactory;
	private ISupplierDao supDao = daoFactory.getSupDao();
	private IPurchaseDao purDao = daoFactory.getPurDao();
	public DaoFactory getDaoFactory() {
		return daoFactory;
	}

	public void setDaoFactory(DaoFactory daoFactory) {
		this.daoFactory = daoFactory;
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
	public boolean login(String phone, String password) {
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
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 查询供应商已成交订单
	 */
	@Override
	public List<Purchase> queryPurchasesBySidPaid(int sid) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 查询供应商待成交订单
	 */
	@Override
	public List<Purchase> queryPurchasesBySidWait(int sid) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
