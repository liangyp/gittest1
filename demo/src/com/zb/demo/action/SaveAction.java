package com.zb.demo.action;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.zb.demo.entity.Scores;
import com.zb.demo.entity.Userinfos;
import com.zb.demo.services.SaveInfoService;

@Controller
public class SaveAction extends ActionSupport {
	@Resource
	private SaveInfoService saveInfoService;

	public SaveInfoService getSaveInfoService() {
		return saveInfoService;
	}

	public void setSaveInfoService(SaveInfoService saveInfoService) {
		this.saveInfoService = saveInfoService;
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
		saveInfoService.saveUser(us, sc);
		return SUCCESS;
	}
	
	
}
