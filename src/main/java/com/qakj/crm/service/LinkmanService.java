package com.qakj.crm.service;

import java.util.List;

import com.qakj.crm.pojo.Linkman;

public interface LinkmanService {

	List<Linkman> getLinkmans();
	
	int addLindman(Linkman linkman);
}
