package com.hcl.product.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class ProductCount {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private int prodId;
	private int productCount;
	private long userId;
	private String prodInterested;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getProdId() {
		return prodId;
	}
	public void setProdId(int prodId) {
		this.prodId = prodId;
	}
	public int getProductCount() {
		return productCount;
	}
	public void setProductCount(int productCount) {
		this.productCount = productCount;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getProdInterested() {
		return prodInterested;
	}
	public void setProdInterested(String prodInterested) {
		this.prodInterested = prodInterested;
	}
	@Override
	public String toString() {
		return "ProductCount [id=" + id + ", prodId=" + prodId + ", productCount=" + productCount + ", userId=" + userId
				+ ", prodInterested=" + prodInterested + "]";
	}	
	
	
	
	
}
