package cn.dlian.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.transaction.annotation.Transactional;

import cn.dlian.entities.Medicine;

@Transactional
public class MedicineDaoImpl implements IMedicineDao {

	private SqlSession sqlSession;
	
	public SqlSession getSqlSession() {
		return sqlSession;
	}

	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	/**
	 * 发布一个药品信息
	 */
	@Override
	public boolean addMedicine(Medicine med) {
		String statement = "cn.dlian.entities.MedicineMapper.addMedicine";
		int x = sqlSession.insert(statement,med);
		return x>0;
	}

	/**
	 * 删除一个药品信息
	 */
	@Override
	public boolean deleteMedicine(int id) {
		String statement = "cn.dlian.entities.MedicineMapper.deleteMedicine";
		int x= sqlSession.delete(statement,id);
		return x>0;
	}

	/**
	 * 修改一个药品信息
	 */
	@Override
	public boolean updateMedicine(Medicine med) {
		String statement = "cn.dlian.entities.MedicineMapper.updateMedicine";
		int x = sqlSession.update(statement,med);
		return x>0;
	}

	/**
	 * 药品查询
	 */
	@Override
	public Medicine queryMedicine(int mid) {
		String statement = "cn.dlian.entities.MedicineMapper.queryMedicine";
		Medicine med = sqlSession.selectOne(statement,mid);
		return med;
	}

	/**
	 * 模糊查询
	 */
	@Override
	public List<Medicine> fuzzyQuery(String meg) {
		String statement = "cn.dlian.entities.MedicineMapper.fuzzyQuery";
		meg = "%" + meg + "%";
		List<Medicine> meds = sqlSession.selectList(statement,meg);
		return meds;
	}

}
