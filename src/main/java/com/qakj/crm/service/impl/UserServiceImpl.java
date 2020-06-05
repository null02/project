package com.qakj.crm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qakj.crm.mapper.UserMapper;
import com.qakj.crm.pojo.User;
import com.qakj.crm.pojo.UserExample;
import com.qakj.crm.pojo.UserExample.Criteria;
import com.qakj.crm.service.UserService;

@Transactional
@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserMapper userMapper;
	@Override
	public User getUserByUsernameAndPassword(String username, String password) {
		UserExample example = new UserExample();
		Criteria criteria = example.createCriteria();
		criteria.andUsernameEqualTo(username).andPasswordEqualTo(password);
		List<User> list=userMapper.selectByExample(example);
		if(list !=null &&list.size()>0){
			return list.get(0);
		}
		return null;
	}
	@Override
	public void updateUserById(Integer id, String password) {
		User user = new User();
		user.setId(id);
		user.setPassword(password);
		userMapper.updateByPrimaryKeySelective(user);
	}

}
