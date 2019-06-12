package cn.dlian.service;

import cn.dlian.entities.User;

public interface IUserService {
	User login(String phone,String password);
	boolean updatePassword(int id,String newPass);
}
