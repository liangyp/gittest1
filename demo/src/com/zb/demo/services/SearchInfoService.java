package com.zb.demo.services;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zb.demo.dao.UserinfosDAO;
import com.zb.demo.entity.Userinfos;

@Service
public class SearchInfoService {
	
	@Resource
	private UserinfosDAO udao;

	public UserinfosDAO getUdao() {
		return udao;
	}

	public void setUdao(UserinfosDAO udao) {
		this.udao = udao;
	}
	
	//查询所有
	public List<Userinfos> findAll(){
		return udao.findAll();
	}
	//按编号查询
	public Userinfos searchSingle(long userid){
		return udao.findById(userid);
	}
	//按名字模糊查询
	public List<Userinfos> searchByName(String name){
		return udao.findUserByName(name);
	}
	
}
