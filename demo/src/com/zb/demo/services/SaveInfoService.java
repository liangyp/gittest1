package com.zb.demo.services;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zb.demo.dao.UserinfosDAO;
import com.zb.demo.entity.Scores;
import com.zb.demo.entity.Userinfos;

@Service
public class SaveInfoService {
	@Resource
	private UserinfosDAO udao;

	public UserinfosDAO getUdao() {
		return udao;
	}

	public void setUdao(UserinfosDAO udao) {
		this.udao = udao;
	}
	
	public void saveUser(Userinfos user,Scores score){
		user.getScoreses().add(score);
		score.setUserinfos(user);
		udao.save(user);
	}
	
	
	
}
