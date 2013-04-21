package com.trav.b2c.po;

import java.util.List;

public class Goods extends UpdatableBean {
	private static final long serialVersionUID = 1L;

	private String name;
	private String title;
	private String description;
	private List<Category> categories;
	private List<Picture> pictures;
	private List<PricePolicy> prices;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	public List<Picture> getPictures() {
		return pictures;
	}

	public void setPictures(List<Picture> pictures) {
		this.pictures = pictures;
	}

	public List<PricePolicy> getPrices() {
		return prices;
	}

	public void setPrices(List<PricePolicy> prices) {
		this.prices = prices;
	}
}
