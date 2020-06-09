package com.qakj.crm.service;

import java.util.List;

import com.qakj.crm.pojo.Customer;
import com.qakj.crm.pojo.Supplier;


public interface SupplierService {
	List<Supplier> getSuppliers(int currentPage,int pageSize,String searchName);
	int getSupplierCount(String searchName);
	Supplier getSupplierById(int id);
	void delete(int id);
	void addSupplier(Supplier supplier);
	Supplier getById(int id);
	void update(Supplier supplier);
}
