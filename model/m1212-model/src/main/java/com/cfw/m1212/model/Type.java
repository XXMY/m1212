package com.cfw.m1212.model;

import java.io.Serializable;

/**
 * @author Fangwei_Cai
 * @time since 2016年3月4日 下午10:02:33
 */
public class Type implements Serializable{

	private static final long serialVersionUID = -1569597872782671922L;
	private Integer id;
	private String type_name;
	
	public Type() {
		super();
	}

	public Type(String type_name){
		this.type_name = type_name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getType_name() {
		return type_name;
	}
	public void setType_name(String type_name) {
		this.type_name = type_name;
	}
	@Override
	public String toString() {
		return "Type [id=" + id + ", type_name=" + type_name + "]";
	}
	
	
}
