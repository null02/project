package com.qakj.crm.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qakj.crm.pojo.Supplier;
import com.qakj.crm.service.SupplierService;

@RequestMapping("/supplierController")
@RestController
public class SupplierController {
	@Autowired
	private SupplierService supplierService;
	@RequestMapping("/getSuppliers")
	public Object getSuppliers(@RequestParam("currentPage") int currentPage,@RequestParam("pageSize") int pageSize,@RequestParam("searchName") String searchName){
		if(searchName == null || "".equals(searchName)){
			searchName = "%%";
		}else{
			searchName = "%"+searchName+"%";
		}
		
		List<Supplier> list = supplierService.getSuppliers(currentPage, pageSize, searchName);
		int count = supplierService.getSupplierCount(searchName);
		//计算总页数
		int countPage = count%pageSize==0?count/pageSize:(count/pageSize)+1;
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("code", "200");
		map.put("data", list);
		map.put("countPage", countPage);
		return map;
	}
	@RequestMapping("/getSupplierById")
	public Object getSupplierById(@RequestParam("id") Integer id){
		Supplier supplier = supplierService.getSupplierById(id);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", "200");
		map.put("data", supplier);
		return map;
	}
	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable("id") int id){
		supplierService.delete(id);
		return "删除成功";
	}
	@RequestMapping("/add")
	public String add(Supplier supplier){
		supplierService.addSupplier(supplier);
		return "添加成功";
	}
	@RequestMapping("/edit/{id}")
	public Supplier getById(@PathVariable("id") Integer id){
		Supplier supplier = supplierService.getById(id);
		return supplier;
	}
	@RequestMapping("/update")
	public String update(Supplier supplier){
		supplierService.update(supplier);
		return "修改成功";
	}
}
