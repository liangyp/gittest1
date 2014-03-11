package com.zb.demo.action;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.zb.demo.services.DeleteUserService;

@Controller
public class DeleteAction extends ActionSupport {
	@Resource
	private DeleteUserService deleteUserService;

	public DeleteUserService getDeleteUserService() {
		return deleteUserService;
	}

	public void setDeleteUserService(DeleteUserService deleteUserService) {
		this.deleteUserService = deleteUserService;
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
		// TODO Auto-generated method stub
		deleteUserService.deleteUser(userid);
		return SUCCESS;
	}
	
}	
