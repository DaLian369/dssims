package cn.dlian.dao;

import cn.dlian.entities.Administrator;

public interface IAdministratorDao extends IUserDao{
	boolean addAdministrator(Administrator adm);
	Administrator queryInfo(int id);
	boolean updateInfo(Administrator adm);
}
