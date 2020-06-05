package com.qakj.crm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qakj.crm.mapper.CustomerMapper;
import com.qakj.crm.pojo.Customer;
import com.qakj.crm.pojo.CustomerExample;
import com.qakj.crm.pojo.CustomerExample.Criteria;
import com.qakj.crm.service.CustomerService;
@Transactional
@Service
public class CustomerServiceImpl implements CustomerService{
	@Autowired
	private CustomerMapper customerMapper;
	@Override
	public List<Customer> getCustomers(int currentPage, int pageSize, String searchName) {
		List<Customer> list = customerMapper.selectCustomers((currentPage-1) * pageSize, pageSize, searchName);
		return list;
	}
	
	@Override
	public int getCustomerCount(String searchName) {
		CustomerExample example = new CustomerExample();
		Criteria criteria = example.createCriteria();
		criteria.andNameLike(searchName);
		int count = customerMapper.countByExample(example);
		return count;
	}

	@Override
	public Customer getCustomerById(int id) {
		Customer customer = customerMapper.selectByPrimaryKey(id);
		return customer;
	}

	@Override
	public void delete(int id) {
		customerMapper.deleteByPrimaryKey(id);
	}

	@Override
	public void addCustomer(Customer customer) {
		customerMapper.insertSelective(customer);
		
	}

	@Override
	public Customer getById(int id) {
		Customer customer = customerMapper.selectByPrimaryKey(id);
		return customer;
	}

	@Override
	public void update(Customer customer) {
		customerMapper.updateByPrimaryKeySelective(customer);
		
	}

}
