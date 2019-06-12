package cn.dlian.entities;

import java.sql.Date;
import java.util.List;

/*
 * 药品类
 */
public class Medicine{
	private int id;
	private String name;
	private String type;
	private float price;
	private Date productionDate;
	private String qualityGuaranteePeriod;
	private List<Supplier> suppliers;
	
	public Medicine() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Medicine( String name, String type, float price, Date productionDate, String qualityGuaranteePeriod) {
		super();
		this.name = name;
		this.type = type;
		this.price = price;
		this.productionDate = productionDate;
		this.qualityGuaranteePeriod = qualityGuaranteePeriod;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public Date getProductionDate() {
		return productionDate;
	}
	public void setProductionDate(Date productionDate) {
		this.productionDate = productionDate;
	}
	public String getQualityGuaranteePeriod() {
		return qualityGuaranteePeriod;
	}
	public void setQualityGuaranteePeriod(String qualityGuaranteePeriod) {
		this.qualityGuaranteePeriod = qualityGuaranteePeriod;
	}
	@Override
	public String toString() {
		return "Medicine [id=" + id + ", name=" + name + ", type=" + type + ", price=" + price + ", productionDate="
				+ productionDate + ", qualityGuaranteePeriod=" + qualityGuaranteePeriod+ "]";
	}
	
}
