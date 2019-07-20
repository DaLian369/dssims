package cn.dlian.service;

import java.util.List;

import cn.dlian.entities.Administrator;
import cn.dlian.entities.Inventory;
import cn.dlian.entities.Medicine;
import cn.dlian.entities.Order;
import cn.dlian.entities.Purchase;

public interface IAdministratorService extends IUserService {
	Administrator queryInfo(int id);
	boolean regist(Administrator adm);
	boolean updateInfo(Administrator adm);
	boolean addMedicine(Medicine med);
	boolean addInventory(int aid,int mid,int sid,int count);
	boolean deleteInventory(int aid,int mid,int sid);
	boolean updateMedicine(Medicine med);
	//Medicine queryMedicine(int mid);
	//List<Medicine> fuzzyQuery(String msg);
	//List<Order> queryOrdersByAid(int aid);
	List<Order> queryOrdersByAidPaid(int aid);
	List<Order> queryOrdersByAidWait(int aid);
	//List<Order> queryOrdersByAidCid(int aid,int cid);
	List<Order> queryOrdersByOidAidCid(Integer oid,Integer aid,Integer cid);
	//Order queryOrderByOid(int oid);
	//List<Purchase> queryPurchasesByAid(int aid);
	List<Purchase> queryPurchasesByAidPaid(int aid);
	List<Purchase> queryPurchasesByAidWait(int aid);
	List<Purchase> queryPurchasesByThreeId(Integer sid,Integer mid,Integer aid);
	//Purchase queryPurchaseByPid(int pid);
	List<Inventory> queryInventory(Integer aid,Integer mid,Integer sid);
	List<Inventory> queryWillSellOut(int aid,int limit);
	boolean placeOnPurchase(Purchase pur);
	boolean payment(int pid);
	boolean canclePurchase(int pid);
}
