package com.zb.demo.services;

import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zb.demo.dao.UserinfosDAO;
import com.zb.demo.entity.Scores;
import com.zb.demo.entity.Userinfos;

@Service
public class UpdateUserService {
	@Resource
	private UserinfosDAO udao;

	public UserinfosDAO getUdao() {
		return udao;
	}

	public void setUdao(UserinfosDAO udao) {
		this.udao = udao;
	}
	
	public void updateUser(Userinfos user,Scores score){
		Userinfos us = udao.findById(user.getUserid());
		us.setUsername(user.getUsername());
		us.setBirthday(user.getBirthday());
		for (Scores sc:(Set<Scores>)us.getScoreses()){
			if (sc.getScid().intValue()==score.getScid().intValue()){
				sc.setScore(score.getScore());
			}
		}
	}
}
