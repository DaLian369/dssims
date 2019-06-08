package cn.dlian.entities;

import java.sql.Date;

/*
 * 采购类
 */
public class Purchase{
	private int id;
	private int aid;
	private int mid;
	private int sid;
	private int qty;
	private float dollars;
	private Date transactionDate;
	private int state;
	
	
	public Purchase() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Purchase(int id, int aid, int mid, int sid, int qty, float dollars, Date transactionDate, int state) {
		super();
		this.id = id;
		this.aid = aid;
		this.mid = mid;
		this.sid = sid;
		this.qty = qty;
		this.dollars = dollars;
		this.transactionDate = transactionDate;
		this.state = state;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public float getDollars() {
		return dollars;
	}
	public void setDollars(float dollars) {
		this.dollars = dollars;
	}
	public Date getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	@Override
	public String toString() {
		return "Purchase [id=" + id + ", aid=" + aid + ", mid=" + mid + ", sid=" + sid + ", qty=" + qty + ", dollars="
				+ dollars + ", transactionDate=" + transactionDate + ", state=" + state + "]";
	}
	
}
