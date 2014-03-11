package com.zb.demo.action;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.zb.demo.entity.Scores;
import com.zb.demo.entity.Userinfos;
import com.zb.demo.services.UpdateUserService;

@Controller
public class UpdateAction extends ActionSupport {
	@Resource
	private UpdateUserService updateUserService;

	public UpdateUserService getUpdateUserService() {
		return updateUserService;
	}

	public void setUpdateUserService(UpdateUserService updateUserService) {
		this.updateUserService = updateUserService;
	}
	
	private Userinfos us;
	private Scores sc;

	public Userinfos getUs() {
		return us;
	}

	public void setUs(Userinfos us) {
		this.us = us;
	}

	public Scores getSc() {
		return sc;
	}

	public void setSc(Scores sc) {
		this.sc = sc;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		updateUserService.updateUser(us, sc);
		return SUCCESS;
	}
	
	
	
}
