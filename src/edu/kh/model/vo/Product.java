package edu.kh.model.vo;

public class Product {
	
	private int pId;
	private String pName;
	private int price;
	private double tax;
	
	public Product() {}
	
	public Product(int pId, String pName, int price, double tax) {
		
		this.pId = pId;
		this.pName = pName;
		this.price = price;
		this.tax = tax;
	}

	public String information() {
		return "";
	}

	public int getpId() {
		return pId;
	}

	public void setpId(int pId) {
		this.pId = pId;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public double getTax() {
		return tax;
	}

	public void setTax(double tax) {
		this.tax = tax;
	}
	
}
