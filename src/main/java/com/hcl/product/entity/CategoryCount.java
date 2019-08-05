package com.hcl.product.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class CategoryCount {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private int categoryCount;
	private int categoryId;
	
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	private long userId;
	private String categoryInterested;	
	
	public int getId() {
		return id;
	}
	public int getCategoryCount() {
		return categoryCount;
	}
	public void setCategoryCount(int categoryCount) {
		this.categoryCount = categoryCount;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getCategoryInterested() {
		return categoryInterested;
	}
	public void setCategoryInterested(String categoryInterested) {
		this.categoryInterested = categoryInterested;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "CategoryCount [id=" + id + ", categoryCount=" + categoryCount + ", categoryId=" + categoryId
				+ ", userId=" + userId + ", categoryInterested=" + categoryInterested + "]";
	}
	
	
	
	
}
