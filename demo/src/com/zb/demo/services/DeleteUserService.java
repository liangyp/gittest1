package com.zb.demo.services;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zb.demo.dao.UserinfosDAO;
import com.zb.demo.entity.Userinfos;

@Service
public class DeleteUserService {
	@Resource
	private UserinfosDAO udao;

	public UserinfosDAO getUdao() {
		return udao;
	}

	public void setUdao(UserinfosDAO udao) {
		this.udao = udao;
	}
	
	public void deleteUser(long userid){
		Userinfos us = udao.findById(userid);
		udao.delete(us);
	}
}
