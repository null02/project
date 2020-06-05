package com.qakj.crm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qakj.crm.mapper.LinkmanMapper;
import com.qakj.crm.pojo.Linkman;
import com.qakj.crm.service.LinkmanService;
@Transactional
@Service
public class LinkmanServiceImpl implements LinkmanService{
	@Autowired
	private LinkmanMapper  linkmanMapper;
	
	@Override
	public List<Linkman> getLinkmans() {
		List<Linkman> linkmans = linkmanMapper.getLinkmans();
		return linkmans;
	}

	@Override
	public int addLindman(Linkman linkman) {
		int i = linkmanMapper.insertSelective(linkman);
		return i;
	}

}
