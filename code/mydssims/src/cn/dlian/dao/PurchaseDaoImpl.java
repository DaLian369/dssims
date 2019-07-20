package cn.dlian.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cn.dlian.entities.Purchase;

@Repository("purDao")
@Transactional
public class PurchaseDaoImpl implements IPurchaseDao {

	@Autowired
	private SqlSession sqlSession;
	
	public SqlSession getSqlSession() {
		return sqlSession;
	}

	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	/**
	 * 添加一个采购单
	 */
	@Override
	public boolean addPurchase(Purchase purchase) {
		String sql = "cn.dlian.entities.PurchaseMapper.addPurchase";
		int x = sqlSession.insert(sql,purchase);
		return x>0;
	}

	/**
	 * 修改采购单状态为“已付款”
	 */
	@Override
	public boolean updatePurchase(int pid,int state) {
		String sql = "cn.dlian.entities.PurchaseMapper.updatePurchase";
		Map<String,Integer> map = new HashMap<>();
		map.put("pid", pid);
		map.put("state", state);
		int x = sqlSession.update(sql,map);
		return x>0;
	}

	/**
	 * 删除一个采购单
	 */
	@Override
	public boolean deletePurchase(int pid) {
		String sql = "cn.dlian.entities.PurchaseMapper.deletePurchase";
		int x = sqlSession.delete(sql,pid);
		return x>0;
	}
	/**
	 * 通过aid查询采购单
	 */
	@Override
	public List<Purchase> queryPurchasesByAid(int aid) {
		String sql = "cn.dlian.entities.PurchaseMapper.queryPurchasesByAid";
		List<Purchase> purchases = sqlSession.selectList(sql,aid);
		return purchases;
	}

	/**
	 * 查询aid管理员的已付款采购单
	 */
	@Override
	public List<Purchase> queryPurchasesByAidPaid(int aid) {
		String sql = "cn.dlian.entities.PurchaseMapper.queryPurchasesByAidPaid";
		List<Purchase> purchases = sqlSession.selectList(sql,aid);
		return purchases;
	}
	/**
	 * 查询aid管理员的待付款采购单
	 */
	@Override
	public List<Purchase> queryPurchasesByAidWait(int aid) {
		String sql = "cn.dlian.entities.PurchaseMapper.queryPurchasesByAidWait";
		List<Purchase> purchases = sqlSession.selectList(sql,aid);
		return purchases;
	}

	/**
	 * 通过pid查询采购单
	 */
	@Override
	public Purchase queryPurchaseByPid(int pid) {
		String sql = "cn.dlian.entities.PurchaseMapper.queryPurchaseByPid";
		Purchase purchase = sqlSession.selectOne(sql,pid);
		return purchase;
	}


	/**
	 * 查询sid供应商下的已付款采购单
	 */
	@Override
	public List<Purchase> queryPurchasesBySidPaid(int sid) {
		String sql = "cn.dlian.entities.PurchaseMapper.queryPurchasesBySidPaid";
		List<Purchase> purchases = sqlSession.selectList(sql,sid);
		return purchases;
	}

	/**
	 * 查询sid供应商下的待付款采购单
	 */
	@Override
	public List<Purchase> queryPurchasesBySidWait(int sid) {
		String sql = "cn.dlian.entities.PurchaseMapper.queryPurchasesBySidWait";
		List<Purchase> purchases = sqlSession.selectList(sql,sid);
		return purchases;
	}

	/**
	 * 通过sid、aid、mid查询采购单
	 */
	@Override
	public List<Purchase> queryPurchasesByThreeId(Integer sid, Integer mid,Integer aid) {
		String sql = "cn.dlian.entities.PurchaseMapper.queryPurchasesByThreeId";
		Map<String,Integer> map = new HashMap<>();
		map.put("sid", sid);
		map.put("aid", aid);
		map.put("mid", mid);
		List<Purchase> purchases = sqlSession.selectList(sql,map);
		return purchases;
	}


}
