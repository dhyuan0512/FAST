package com.cy.fast.common.vo;

import java.io.Serializable;

import lombok.Data;
@Data
public class Node implements Serializable{
	private static final long serialVersionUID = -6577397050669133046L;
	
	private Integer id;
	private String name;
	private Integer parentId;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getParentId() {
		return parentId;
	}
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
	@Override
	public String toString() {
		return "Node [id=" + id + ", name=" + name + ", parentId=" + parentId + "]";
	}
	
}
