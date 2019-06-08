package cn.dlian.dao;

public interface IUserDao {
	boolean login(int id,String password);
	boolean updatePassword(int id,String newPass);
}
