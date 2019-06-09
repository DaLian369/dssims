package cn.dlian.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.transaction.annotation.Transactional;

import cn.dlian.entities.Supplier;

@Transactional
public class SupplierDaoImpl implements ISupplierDao {

	private SqlSession sqlSession;
	
	public SqlSession getSqlSession() {
		return sqlSession;
	}

	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	

	/**
	 * 供应商信息查询
	 */
	@Override
	public Supplier queryInfo(int id) {
		String statement = "cn.dlian.entities.SupplierMapper.queryInfo";
		Supplier sup = sqlSession.selectOne(statement,1);
		return sup;
	}
	
	/**
	 * 供应商登陆
	 */
	@Override
	public boolean login(String phone, String password) {
		String statement = "cn.dlian.entities.SupplierMapper.login";
		Supplier sup = new Supplier();
		sup.setPhone(phone);
		sup.setPassword(password);
		sup = sqlSession.selectOne(statement,sup);
		return sup!=null;
	}

	/**
	 * 供应商修改密码
	 */
	@Override
	public boolean updatePassword(int id, String newPass) {
		String statement = "cn.dlian.entities.SupplierMapper.updatePassword";
		Supplier sup = new Supplier();
		sup.setId(id);
		sup.setPassword(newPass);
		int x = sqlSession.update(statement,sup);
		return x>0;
	}

	/**
	 * 供应商注册
	 */
	@Override
	public boolean addSupplier(Supplier sup) {
		String statement = "cn.dlian.entities.SupplierMapper.addSupplier";
		try{
			return sqlSession.insert(statement,sup)>0;
		}catch(Exception e) {
			return false;
		}
		
	}


	/**
	 * 供应商修改信息
	 */
	@Override
	public boolean updateInfo(Supplier sup) {
		String statement = "cn.dlian.entities.SupplierMapper.updateInfo";
		int x = sqlSession.update(statement,sup);
		return x>0;
	}

}
