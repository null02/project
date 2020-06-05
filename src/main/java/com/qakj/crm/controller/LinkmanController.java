package com.qakj.crm.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qakj.crm.pojo.Linkman;
import com.qakj.crm.service.LinkmanService;

@RequestMapping("/linkmanController")
@RestController
public class LinkmanController {
	@Autowired
	private LinkmanService linkmanService;
	
	@RequestMapping("/getLinkmans")
	public Object getLinkmans(){
		List<Linkman> list = linkmanService.getLinkmans();
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("code", "200");
		map.put("data", list);
		return map;
	}
	@RequestMapping("/addLinkman")
	public Object addLinkman(Linkman linkman){
		int i = linkmanService.addLindman(linkman);
		Map<String,Object> map = new HashMap<String,Object>();
		if(i > 0){
			map.put("code", "200");
			map.put("msg", "添加成功");
			return map;
		}
		map.put("code", "444");
		map.put("msg", "添加失败");
		return map;
	}

}
