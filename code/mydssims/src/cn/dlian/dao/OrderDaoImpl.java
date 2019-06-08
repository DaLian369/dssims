package cn.dlian.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import cn.dlian.entities.Order;

public class OrderDaoImpl implements IOrderDao {

	private SqlSession sqlSession;
	
	public SqlSession getSqlSession() {
		return sqlSession;
	}

	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	/**
	 * 添加一张订单
	 */
	@Override
	public boolean addOrder(Order order) {
		String statement = "cn.dlian.entities.OrderMapper.addOrder";
		int x = sqlSession.insert(statement,order);
		return x>0;
	}

	/**
	 * 付款，即修改订单
	 */
	@Override
	public boolean updateOrder(int oid,int state) {
		String statement = "cn.dlian.entities.OrderMapper.updateOrder";
		Map<String,Integer> map = new HashMap<>();
		map.put("oid", oid);
		map.put("state",state);
		int x = sqlSession.update(statement,map);
		return x>0;
	}

	/**
	 * 取消订单
	 */
	@Override
	public boolean deleteOrder(int oid) {
		String statement = "cn.dlian.entities.OrderMapper.deleteOrder";
		int x = sqlSession.delete(statement,oid);
		return x>0;
	}
	
	/**
	 * 通过cid查询订单
	 */
	@Override
	public List<Order> queryOrdersByCid(int cid) {
		String statement = "cn.dlian.entities.OrderMapper.queryOrdersByCid";
		List<Order> orders = sqlSession.selectList(statement,cid);
		return orders;
	}

	/**
	 * 查询cid客户的已付款订单
	 */
	@Override
	public List<Order> queryOrdersByCidPaid(int cid) {
		String statement = "cn.dlian.entities.OrderMapper.queryOrdersByCidPaid";
		List<Order> orders = sqlSession.selectList(statement,cid);
		return orders;
	}

	/**
	 * 查询cid客户的待付款订单
	 */
	@Override
	public List<Order> queryOrdersByCidWait(int cid) {
		String statement = "cn.dlian.entities.OrderMapper.queryOrdersByCidWait";
		List<Order> orders = sqlSession.selectList(statement,cid);
		return orders;
	}

	/**
	 * 通过oid查询订单
	 */
	@Override
	public Order queryOrderByOid(int oid) {
		String statement = "cn.dlian.entities.OrderMapper.queryOrdersByOid";
		Order order = sqlSession.selectOne(statement,oid);
		return order;
	}

	/**
	 * 查询aid管理员的订单
	 */
	@Override
	public List<Order> queryOrdersByAid(int aid) {
		String statement = "cn.dlian.entities.OrderMapper.queryOrdersByAid";
		List<Order> orders = sqlSession.selectList(statement,aid);
		return orders;
	}

	/**
	 * 查询aid管理员下的已付款的订单
	 */
	@Override
	public List<Order> queryOrdersByAidPaid(int aid) {
		String statement = "cn.dlian.entities.OrderMapper.queryOrdersByAidPaid";
		List<Order> orders = sqlSession.selectList(statement,aid);
		return orders;
	}

	/**
	 * 查询aid管理员下的待付款的订单
	 */
	@Override
	public List<Order> queryOrdersByAidWait(int aid) {
		String statement = "cn.dlian.entities.OrderMapper.queryOrdersByAidWait";
		List<Order> orders = sqlSession.selectList(statement,aid);
		return orders;
	}

	/**
	 * 通过aid，cid查询订单
	 */
	@Override
	public List<Order> queryOrdersByAidCid(int aid, int cid) {
		String statement = "cn.dlian.entities.OrderMapper.queryOrdersByAidCid";
		Map<String,Integer> map = new HashMap<>();
		map.put("aid", aid);
		map.put("cid",cid);
		List<Order> orders = sqlSession.selectList(statement,map);
		return orders;
	}



}
