package cn.dlian.service;

public interface IUserService {
	boolean login(String phone,String password);
	boolean updatePassword(int id,String newPass);
}
