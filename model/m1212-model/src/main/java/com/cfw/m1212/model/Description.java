package com.cfw.m1212.model;


import java.io.Serializable;

/**
 * @author Fangwei_Cai
 * @time since 2016年3月4日 下午10:04:52
 */
public class Description implements Serializable{

	private static final long serialVersionUID = -3298378439179003879L;
	private Integer id;

	private String abstract_;

	private String description;

	private boolean isDeleted;

	public Description() {
		super();
	}

	public Description(String description){
		this.description = description;
		this.isDeleted = false;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAbstract_() {
		return abstract_;
	}

	public void setAbstract_(String abstract_) {
		this.abstract_ = abstract_;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isDeleted() {
		return isDeleted;
	}

	public void setDeleted(boolean deleted) {
		this.isDeleted = deleted;
	}

	@Override
	public String toString() {
		return "Description [id=" + id + ", abstract_=" + abstract_ + ", description=" + description + ", isDeleted="
				+ isDeleted + "]";
	}
	
	
	
}
