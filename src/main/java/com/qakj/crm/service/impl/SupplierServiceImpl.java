package com.qakj.crm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qakj.crm.mapper.SupplierMapper;
import com.qakj.crm.pojo.Customer;
import com.qakj.crm.pojo.Supplier;
import com.qakj.crm.pojo.SupplierExample;
import com.qakj.crm.pojo.SupplierExample.Criteria;
import com.qakj.crm.service.SupplierService;

@Transactional
@Service
public class SupplierServiceImpl implements SupplierService{
	@Autowired
	private SupplierMapper supplierMapper;
	@Override
	public List<Supplier> getSuppliers(int currentPage, int pageSize, String searchName) {
		List<Supplier> list = supplierMapper.selectSuppliers((currentPage-1) * pageSize, pageSize, searchName);
		return list;
	}

	@Override
	public int getSupplierCount(String searchName) {
		SupplierExample example = new SupplierExample();
		Criteria criteria = example.createCriteria();
		criteria.andNameLike(searchName);
		int count = supplierMapper.countByExample(example);
		return count;
	}

	@Override
	public Supplier getSupplierById(int id) {
		Supplier supplier = supplierMapper.selectByPrimaryKey(id);
		return supplier;
	}

	@Override
	public void delete(int id) {
		supplierMapper.deleteByPrimaryKey(id);
		
	}

	@Override
	public void addSupplier(Supplier supplier) {
		supplierMapper.insertSelective(supplier);
		
	}

	@Override
	public Supplier getById(int id) {
		Supplier supplier = supplierMapper.selectByPrimaryKey(id);
		return supplier;
	}

	@Override
	public void update(Supplier supplier) {
		supplierMapper.updateByPrimaryKeySelective(supplier);
		
	}

}
