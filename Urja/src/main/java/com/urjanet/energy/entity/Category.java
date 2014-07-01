package com.urjanet.energy.entity;

import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.google.gson.annotations.SerializedName;

@Entity
@Table(name = "urja_category")
@SequenceGenerator(name = "idSeqGen", sequenceName = "SEQ_URJA_CATEGORY")
public class Category {
	@Id
	@GeneratedValue(generator = "idSeqGen", strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "category_id")
	@SerializedName("category_id")
	// this is for JSON, this is what appears in the file
	private String categoryId; // this is what WE(java/this Class) would like to
								// call it by

	@Column(name = "parent_category_id")
	@SerializedName("parent_category_id")
	private String parentCategoryId;

	private String name;
	private String notes;

	@ElementCollection
	@CollectionTable(name = "urja_category_childseries", joinColumns = @JoinColumn(name = "category_id"))
	@Column(name = "child_series_id")
	@SerializedName("childseries")
	private List<String> childSeries;

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public String getParentCategoryId() {
		return parentCategoryId;
	}

	public void setParentCategoryId(String parentCategoryId) {
		this.parentCategoryId = parentCategoryId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public List<String> getChildSeries() {
		return childSeries;
	}

	public void setChildSeries(List<String> childSeries) {
		this.childSeries = childSeries;
	}

	public Long getId() {
		return id;
	}

}