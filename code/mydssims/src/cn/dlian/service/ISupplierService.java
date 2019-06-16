package cn.dlian.service;

import java.util.List;

import cn.dlian.entities.Purchase;
import cn.dlian.entities.Supplier;

public interface ISupplierService extends IUserService {
		boolean regist(Supplier sup);
		Supplier queryInfo(int id);
		boolean updateInfo(Supplier sup);
		List<Purchase> queryPurchasesBySid(int sid);
		List<Purchase> queryPurchasesBySidPaid(int sid);
		List<Purchase> queryPurchasesBySidWait(int sid);
		List<Purchase> queryPurchasesByThreeId(Integer sid,Integer mid,Integer aid);
}
