package cn.dlian.dao;

import java.util.List;

import cn.dlian.entities.Purchase;

public interface IPurchaseDao {
	List<Purchase> queryPurchasesByAid(int aid);
	List<Purchase> queryPurchasesByAidPaid(int aid);
	List<Purchase> queryPurchasesByAidWait(int aid);
	Purchase queryPurchaseByPid(int pid);
	List<Purchase> queryPurchasesBySid(int sid);
	List<Purchase> queryPurchasesBySidPaid(int sid);
	List<Purchase> queryPurchasesBySidWait(int sid);
	List<Purchase> queryPurchasesBySidAid(int sid,int aid);
	boolean addPurchase(Purchase purchase);
	boolean updatePurchase(int pid,int state);
	boolean deletePurchase(int pid);
}