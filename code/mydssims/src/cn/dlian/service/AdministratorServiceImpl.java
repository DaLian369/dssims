package cn.dlian.service;

import cn.dlian.dao.IAdministratorDao;
import cn.dlian.entities.Administrator;

public class AdministratorServiceImpl implements IAdministratorService{
	private IAdministratorDao admDao;
	
	public IAdministratorDao getAdmDao() {
		return admDao;
	}

	public void setAdmDao(IAdministratorDao admDao) {
		this.admDao = admDao;
	}

	@Override
	public Administrator queryInfo(int id) {
		Administrator adm = admDao.queryInfo(id);
		
		return adm;
	}

	@Override
	public boolean regist(Administrator adm) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateInfo(Administrator adm) {
		// TODO Auto-generated method stub
		return false;
	}

}
