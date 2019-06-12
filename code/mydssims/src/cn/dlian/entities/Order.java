package cn.dlian.entities;

import java.sql.Date;

/*
 * 订单类
 */
public class Order extends Purchase {
	private int cid;
	
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Order(int cid,int aid, int mid, int sid, int qty, float dollars, Date transactionDate, int state) {
		super(aid, mid, sid, qty, dollars, transactionDate, state);
		this.cid = cid;
		// TODO Auto-generated constructor stub
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}
}
