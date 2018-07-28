package com.hcq.entity;

/**
 * RolePower entity. @author MyEclipse Persistence Tools
 */

public class RolePower implements java.io.Serializable {

	// Fields

	private Integer id;
	private Role role;
	private Power power;

	// Constructors

	/** default constructor */
	public RolePower() {
	}

	/** minimal constructor */
	public RolePower(Role role) {
		this.role = role;
	}

	/** full constructor */
	public RolePower(Role role, Power power) {
		this.role = role;
		this.power = power;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Power getPower() {
		return this.power;
	}

	public void setPower(Power power) {
		this.power = power;
	}

}