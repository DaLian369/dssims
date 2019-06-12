package cn.dlian.entities;

import java.util.List;

/*
 * 供应商类
 */
public class Supplier extends User {
	private String city;
	private List<Purchase> purchases;
	private List<Medicine> medicines;

	public Supplier() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Supplier(String name, String password, String phone,String city) {
		super(name, password, phone);
		this.city = city;
		// TODO Auto-generated constructor stub
	}
	
	public List<Purchase> getPurchases() {
		return purchases;
	}

	

	public void setPurchases(List<Purchase> purchases) {
		this.purchases = purchases;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public List<Medicine> getMedicines() {
		return medicines;
	}

	public void setMedicines(List<Medicine> medicines) {
		this.medicines = medicines;
	}
	
}
