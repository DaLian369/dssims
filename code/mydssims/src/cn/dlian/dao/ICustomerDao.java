package cn.dlian.dao;

import cn.dlian.entities.Customer;

public interface ICustomerDao extends IUserDao {
	boolean addCustomer(Customer cus);
	Customer queryInfo(int id);
	boolean updateInfo(Customer cus);
	
}
