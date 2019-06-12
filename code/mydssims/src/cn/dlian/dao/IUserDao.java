package cn.dlian.dao;

import cn.dlian.entities.User;

public interface IUserDao {
	User login(String phone,String password);
	boolean updatePassword(int id,String newPass);
}
