package com.zb.demo.action;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.zb.demo.entity.Userinfos;
import com.zb.demo.services.SearchInfoService;

@Controller
public class SingleAction extends ActionSupport {
	@Resource
	private SearchInfoService searchInfoService;

	public SearchInfoService getSearchInfoService() {
		return searchInfoService;
	}

	public void setSearchInfoService(SearchInfoService searchInfoService) {
		this.searchInfoService = searchInfoService;
	}
	
	private Userinfos user;

	public Userinfos getUser() {
		return user;
	}

	public void setUser(Userinfos user) {
		this.user = user;
	}
	private long userid;
	
	public long getUserid() {
		return userid;
	}

	public void setUserid(long userid) {
		this.userid = userid;
	}

	@Override
	public String execute() throws Exception {
		user = searchInfoService.searchSingle(userid);
		return SUCCESS;
	}
	
}
