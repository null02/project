package com.qakj.crm.service;

import java.util.List;

import com.qakj.crm.pojo.Customer;
import com.qakj.crm.pojo.User;

public interface UserService {
	User getUserByUsernameAndPassword(String username,String password);
	void updateUserById(Integer id,String password);
	List<User> getUsers(int currentPage,int pageSize,String searchName);
	int getUserCount(String searchName);
	User getUserById(int id);
	void delete(int id);
	void addUser(User user);
	User getById(int id);
	void update(User user);
}
