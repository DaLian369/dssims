package cn.dlian.entities;

public class Inventory {
	private Medicine medicine;
	private Supplier supplier;
	private int count;
	public Inventory(Medicine medicine, Supplier supplier, int count) {
		super();
		this.medicine = medicine;
		this.supplier = supplier;
		this.count = count;
	}
	public Inventory() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Medicine getMedicine() {
		return medicine;
	}
	public void setMedicine(Medicine medicine) {
		this.medicine = medicine;
	}
	public Supplier getSupplier() {
		return supplier;
	}
	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	@Override
	public String toString() {
		return "Inventory [medicine=" + medicine + ", supplier=" + supplier + ", count=" + count + "]";
	}
	
	
}
