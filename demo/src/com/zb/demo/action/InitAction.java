package com.zb.demo.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.zb.demo.entity.Userinfos;
import com.zb.demo.services.SearchInfoService;

@Controller
@Scope("prototype")
public class InitAction extends ActionSupport {
	@Resource
	private SearchInfoService searchInfoService;

	public SearchInfoService getSearchInfoService() {
		return searchInfoService;
	}

	public void setSearchInfoService(SearchInfoService searchInfoService) {
		this.searchInfoService = searchInfoService;
	}
	
	private List<Userinfos> users;

	public List<Userinfos> getUsers() {
		return users;
	}

	public void setUsers(List<Userinfos> users) {
		this.users = users;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		users = searchInfoService.findAll();
		return SUCCESS;
	}
	
	
}
