package cn.dlian.dao;

import java.util.List;

import cn.dlian.entities.Inventory;

public interface IInventoryDao {
	List<Inventory> queryInventory(int aid,int mid,int sid);
	boolean updateInventory(int aid,int mid,int sid,int value);
	boolean addInventory(int aid,int mid,int sid,int count);
	boolean deleteInventory(int aid,int mid,int sid);
}
