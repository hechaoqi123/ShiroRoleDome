package com.hcq.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Role entity. @author MyEclipse Persistence Tools
 */

public class Role implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private String remark;
	private Set rolePowers = new HashSet(0);
	private Set userRoles = new HashSet(0);

	// Constructors

	/** default constructor */
	public Role() {
	}

	/** minimal constructor */
	public Role(String name) {
		this.name = name;
	}

	/** full constructor */
	public Role(String name, String remark, Set rolePowers, Set userRoles) {
		this.name = name;
		this.remark = remark;
		this.rolePowers = rolePowers;
		this.userRoles = userRoles;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
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

	public Set getUserRoles() {
		return this.userRoles;
	}

	public void setUserRoles(Set userRoles) {
		this.userRoles = userRoles;
	}

}