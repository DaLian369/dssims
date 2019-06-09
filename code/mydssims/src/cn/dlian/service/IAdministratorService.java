package cn.dlian.service;

import java.util.List;

import cn.dlian.entities.Administrator;
import cn.dlian.entities.Inventory;
import cn.dlian.entities.Medicine;
import cn.dlian.entities.Order;
import cn.dlian.entities.Purchase;

public interface IAdministratorService extends IUserService {
	boolean regist(Administrator adm);
	Administrator queryInfo(int id);
	boolean updateInfo(Administrator adm);
	boolean addMedicine(Medicine med);
	boolean deleteMedicine(int mid);
	boolean updateMedicine(Medicine mmed);
	Medicine queryMedicine(int mid);
	List<Medicine> fuzzyQuery(String msg);
	List<Order> queryOrdersByAid(int aid);
	List<Order> queryOrdersByAidPaid(int aid);
	List<Order> queryOrdersByAidWait(int aid);
	List<Order> queryOrdersByAidCid(int aid,int cid);
	Order queryOrderByOid(int oid);
	List<Purchase> queryPurchasesByAid(int aid);
	List<Purchase> queryPurchasesByAidPaid(int aid);
	List<Purchase> queryPurchasesByAidWait(int aid);
	List<Purchase> queryPurchasesBySidAid(int sid,int aid);
	Purchase queryPurchaseByPid(int pid);
	List<Inventory> queryInventory(int aid,int mid,int sid);
	boolean placeOnPurcahse(Purchase pur);
	boolean payment(int pid);
	boolean canclePurchase(int pid);
}
