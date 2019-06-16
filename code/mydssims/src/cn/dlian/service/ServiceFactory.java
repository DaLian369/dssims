package cn.dlian.service;

import org.springframework.beans.factory.annotation.Autowired;

public class ServiceFactory {
	@Autowired
	private IAdministratorService admService;
	@Autowired
	private ICustomerService cusService;
	@Autowired
	private ISupplierService supService;
	public IAdministratorService getAdmService() {
		return admService;
	}
	public void setAdmService(IAdministratorService admService) {
		this.admService = admService;
	}
	public ICustomerService getCusService() {
		return cusService;
	}
	public void setCusService(ICustomerService cusService) {
		this.cusService = cusService;
	}
	public ISupplierService getSupService() {
		return supService;
	}
	public void setSupService(ISupplierService supService) {
		this.supService = supService;
	}
	
}
