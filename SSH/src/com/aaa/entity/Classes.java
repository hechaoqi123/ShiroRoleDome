package com.aaa.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Classes entity. @author MyEclipse Persistence Tools
 */

public class Classes implements java.io.Serializable {

	// Fields

	private Integer cid;
	private String cname;
	private Set students = new HashSet(0);

	// Constructors

	/** default constructor */
	public Classes() {
	}

	/** full constructor */
	public Classes(String cname, Set students) {
		this.cname = cname;
		this.students = students;
	}

	// Property accessors

	public Integer getCid() {
		return this.cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public String getCname() {
		return this.cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public Set getStudents() {
		return this.students;
	}

	public void setStudents(Set students) {
		this.students = students;
	}

}