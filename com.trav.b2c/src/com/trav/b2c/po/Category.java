package com.trav.b2c.po;

import java.util.List;

public class Category extends UpdatableBean {
	private static final long serialVersionUID = 1L;

	public enum Layer {
		I, II, III, IV, V
	}

	private String name;
	private String description;
	private Layer layer;// ²ã¼¶
	private long parentCategoryUid;
	private Category parentCategory;
	private List<Category> childCategories;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Layer getLayer() {
		return layer;
	}

	public void setLayer(Layer layer) {
		this.layer = layer;
	}

	public Category getParentCategory() {
		return parentCategory;
	}

	public void setParentCategory(Category parentCategory) {
		this.parentCategory = parentCategory;
	}

	public List<Category> getChildCategories() {
		return childCategories;
	}

	public void setChildCategories(List<Category> childCategories) {
		this.childCategories = childCategories;
	}

	public long getParentCategoryUid() {
		return parentCategoryUid;
	}

	public void setParentCategoryUid(long parentCategoryUid) {
		this.parentCategoryUid = parentCategoryUid;
	}
}
