package com.imcore.common.model;

import java.io.Serializable;

public class ProductCategory implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3103094007761295713L;
	public Long id;
	public String categoryName;
	public String description;
	public String imageUrl;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
}
