package cn.dlian.service;

import cn.dlian.entities.Administrator;

public interface IAdministratorService {
	boolean regist(Administrator adm);
	Administrator queryInfo(int id);
	boolean updateInfo(Administrator adm);
}
