package cn.dlian.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.transaction.annotation.Transactional;

import cn.dlian.entities.Administrator;

@Transactional
public class AdministratorDaoImpl implements IAdministratorDao {
	private SqlSession sqlSession;
	
	public SqlSession getSqlSession() {
		return sqlSession;
	}
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	/**
	 * 查询管理员信息
	 */
	@Override
	public Administrator queryInfo(int id) {
	
		String statement = "cn.dlian.entities.AdministratorMapper.queryInfo";
		
		Administrator adm = (Administrator)sqlSession.selectOne(statement, id);
		
		return adm;
	}

	/**
	 * 管理员登陆
	 */
	@Override
	public boolean login(int id, String password) {
		String statement = "cn.dlian.entities.AdministratorMapper.login";
		Administrator adm = new Administrator();
		adm.setId(id);
		adm.setPassword(password);
		adm = sqlSession.selectOne(statement, adm);
		return adm!=null;
	}

	/**
	 * 管理员修改密码
	 */
	@Override
	public boolean updatePassword(int id, String newPass) {
		String statement = "cn.dlian.entities.AdministratorMapper.updatePassword";
		Administrator adm = new Administrator();
		adm.setId(id);
		adm.setPassword(newPass);
		int x = sqlSession.update(statement,adm);
		return x>0;
	}

	/**
	 * 添加管理员
	 */
	@Override
	public boolean addAdministrator(Administrator adm) {
		String statement = "cn.dlian.entities.AdministratorMapper.addAdministrator";
		int x = sqlSession.update(statement,adm);
		return x>0;
	}

	/**
	 * 管理员信息修改
	 */
	@Override
	public boolean updateInfo(Administrator adm) {
		String statement = "cn.dlian.entities.AdministratorMapper.updateInfo";
		int x = sqlSession.update(statement,adm);
		return x>0;
	}

}
