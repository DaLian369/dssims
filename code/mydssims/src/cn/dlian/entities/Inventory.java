package cn.dlian.entities;

public class Inventory {
	private Administrator adm;
	private Medicine med;
	private Supplier sup;
	private int count;
	public Inventory(Administrator adm, Medicine med, Supplier sup, int count) {
		super();
		this.adm = adm;
		this.med = med;
		this.sup = sup;
		this.count = count;
	}
	public Inventory() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Administrator getAdm() {
		return adm;
	}
	public void setAdm(Administrator adm) {
		this.adm = adm;
	}
	public Medicine getMed() {
		return med;
	}
	public void setMed(Medicine med) {
		this.med = med;
	}
	public Supplier getSup() {
		return sup;
	}
	public void setSup(Supplier sup) {
		this.sup = sup;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	@Override
	public String toString() {
		return "Inventory [adm=" + adm + ", med=" + med + ", sup=" + sup + ", count=" + count + "]";
	}
	
	
	
}
