package cn.dlian.dao;

import cn.dlian.entities.Supplier;

public interface ISupplierDao extends IUserDao {
		boolean addSupplier(Supplier sup);
		Supplier queryInfo(int id);
		boolean updateInfo(Supplier sup);
}
