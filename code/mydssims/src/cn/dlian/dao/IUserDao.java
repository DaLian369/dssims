package cn.dlian.dao;

public interface IUserDao {
	boolean login(String phone,String password);
	boolean updatePassword(int id,String newPass);
}
