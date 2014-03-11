package com.zb.demo.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Userinfos entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Userinfos implements java.io.Serializable {

	// Fields

	private Long userid;
	private String username;
	private Date birthday;
	private Set scoreses = new HashSet(0);

	// Constructors

	/** default constructor */
	public Userinfos() {
	}

	/** minimal constructor */
	public Userinfos(String username, Date birthday) {
		this.username = username;
		this.birthday = birthday;
	}

	/** full constructor */
	public Userinfos(String username, Date birthday, Set scoreses) {
		this.username = username;
		this.birthday = birthday;
		this.scoreses = scoreses;
	}

	// Property accessors

	public Long getUserid() {
		return this.userid;
	}

	public void setUserid(Long userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Date getBirthday() {
		return this.birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Set getScoreses() {
		return this.scoreses;
	}

	public void setScoreses(Set scoreses) {
		this.scoreses = scoreses;
	}

}