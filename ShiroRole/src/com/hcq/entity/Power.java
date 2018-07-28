package com.hcq.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Power entity. @author MyEclipse Persistence Tools
 */

public class Power implements java.io.Serializable {

	// Fields

	private Integer id;
	private String address;
	private Integer parent;
	private String remark;
	private Set rolePowers = new HashSet(0);

	// Constructors

	/** default constructor */
	public Power() {
	}

	/** minimal constructor */
	public Power(String address, Integer parent) {
		this.address = address;
		this.parent = parent;
	}

	/** full constructor */
	public Power(String address, Integer parent, String remark, Set rolePowers) {
		this.address = address;
		this.parent = parent;
		this.remark = remark;
		this.rolePowers = rolePowers;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getParent() {
		return this.parent;
	}

	public void setParent(Integer parent) {
		this.parent = parent;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Set getRolePowers() {
		return this.rolePowers;
	}

	public void setRolePowers(Set rolePowers) {
		this.rolePowers = rolePowers;
	}

}