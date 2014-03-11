package com.zb.demo.entity;

/**
 * Scores entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Scores implements java.io.Serializable {

	// Fields

	private Long scid;
	private Userinfos userinfos;
	private Long score;

	// Constructors

	/** default constructor */
	public Scores() {
	}

	/** full constructor */
	public Scores(Userinfos userinfos, Long score) {
		this.userinfos = userinfos;
		this.score = score;
	}

	// Property accessors

	public Long getScid() {
		return this.scid;
	}

	public void setScid(Long scid) {
		this.scid = scid;
	}

	public Userinfos getUserinfos() {
		return this.userinfos;
	}

	public void setUserinfos(Userinfos userinfos) {
		this.userinfos = userinfos;
	}

	public Long getScore() {
		return this.score;
	}

	public void setScore(Long score) {
		this.score = score;
	}

}