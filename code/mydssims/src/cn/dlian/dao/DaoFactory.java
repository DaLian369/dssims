package cn.dlian.dao;

import org.springframework.beans.factory.annotation.Autowired;

public class DaoFactory {
	@Autowired
	private ICustomerDao cusDao;
	@Autowired
	private IAdministratorDao admDao;
	@Autowired
	private ISupplierDao supDao;
	@Autowired
	private IMedicineDao medDao;
	@Autowired
	private IInventoryDao invDao;
	@Autowired
	private IOrderDao orderDao;
	@Autowired
	private IPurchaseDao purDao;
	@Autowired
	public ICustomerDao getCusDao() {
		return cusDao;
	}
	public void setCusDao(ICustomerDao cusDao) {
		this.cusDao = cusDao;
	}
	public IAdministratorDao getAdmDao() {
		return admDao;
	}
	public void setAdmDao(IAdministratorDao admDao) {
		this.admDao = admDao;
	}
	public ISupplierDao getSupDao() {
		return supDao;
	}
	public void setSupDao(ISupplierDao supDao) {
		this.supDao = supDao;
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
}
