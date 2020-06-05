package com.qakj.crm.service;

import com.qakj.crm.pojo.User;

public interface UserService {
	User getUserByUsernameAndPassword(String username,String password);
	void updateUserById(Integer id,String password);
}
