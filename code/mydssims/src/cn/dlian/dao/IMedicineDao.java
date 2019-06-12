package cn.dlian.dao;

import java.util.List;

import cn.dlian.entities.Medicine;

public interface IMedicineDao {
	boolean addMedicine(Medicine med);
	boolean deleteMedicine(int id);
	boolean updateMedicine(Medicine med);
	Medicine queryMedicine(int mid);
	List<Medicine> fuzzyQuery(String msg);
}
