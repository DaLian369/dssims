package cn.dlian.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.transaction.annotation.Transactional;

import cn.dlian.entities.Inventory;

@Transactional
public class InventoryDaoImpl implements IInventoryDao {

private SqlSession sqlSession;
	
	public SqlSession getSqlSession() {
		return sqlSession;
	}

	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	/**
	 * 查询库存
	 */
	@Override
	public List<Inventory> queryInventory(Integer aid, Integer mid, Integer sid) {
		String sql = "cn.dlian.entities.InventoryMapper.queryInventory";
		Map<String,Integer> map = new HashMap<>();
		map.put("aid", aid);
		map.put("mid", mid);
		map.put("sid", sid);
		List<Inventory> inventories = sqlSession.selectList(sql,map);
		return inventories;
	}

	/**
	 * 修改库存
	 */
	@Override
	public boolean updateInventory(int aid, int mid, int sid, int value) {
		String sql = "cn.dlian.entities.InventoryMapper.updateInventory";
		Map<String,Integer> map = new HashMap<>();
		map.put("aid", aid);
		map.put("mid", mid);
		map.put("sid", sid);
		map.put("value", value);
		int x = sqlSession.update(sql,map);
		return x>0;
	}

	/**
	 * 添加新品
	 */
	@Override
	public boolean addInventory(int aid,int mid,int sid,int count) {
		String sql = "cn.dlian.entities.InventoryMapper.addInventory";
		Map<String,Integer> map = new HashMap<>();
		map.put("aid", aid);
		map.put("mid", mid);
		map.put("sid", sid);
		map.put("count", count);
		int x = sqlSession.insert(sql,map);
		return x>0;
	}

	/**
	 * 删除药品
	 */
	@Override
	public boolean deleteInventory(int aid, int mid, int sid) {
		String sql = "cn.dlian.entities.InventoryMapper.deleteInventory";
		Map<String,Integer> map = new HashMap<>();
		map.put("aid", aid);
		map.put("mid", mid);
		map.put("sid", sid);
		int x = sqlSession.delete(sql,map);
		return x>0;
	}

	/**
	 * 将要售罄的药品
	 */
	@Override
	public List<Inventory> queryWillSellOut(int aid, int limit) {
		String sql = "cn.dlian.entities.InventoryMapper.queryWillSellOut";
		Map<String,Integer> map = new HashMap<>();
		map.put("aid", aid);
		map.put("limit", limit);
		List<Inventory> invs = sqlSession.selectList(sql,map);
		return invs;
	}

	/**
	 * 模糊查询
	 */
	@Override
	public List<Inventory> fuzzyQuery(String msg) {
		String sql = "cn.dlian.entities.InventoryMapper.fuzzyQuery";
		msg = "%" + msg + "%";
		List<Inventory> invs = sqlSession.selectList(sql,msg);
		return invs;
	}

}
