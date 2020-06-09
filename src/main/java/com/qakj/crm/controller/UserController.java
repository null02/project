package com.qakj.crm.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qakj.crm.pojo.User;
import com.qakj.crm.service.UserService;

@RequestMapping("/userController")
@RestController
public class UserController {
	@Autowired
	private UserService userService;
	@RequestMapping("/login")
	public Map<String,Object> login(@RequestParam("username") String username,@RequestParam("password") String password,HttpSession session){
		Map<String,Object> map = new HashMap<String, Object>();
		User user = userService.getUserByUsernameAndPassword(username, password);
		if(user != null){
			session.setAttribute("user", user);
			map.put("code", "200");
			map.put("msg", "登录成功");
			return map;
		}
		map.put("code", "404");
		map.put("msg", "未找到该用户");
		return map;
	}
	@RequestMapping("/user")
	public Map<String,Object> user(HttpSession session){
		Map<String,Object> map = new HashMap<String, Object>();
		Object user = session.getAttribute("user");
		if(user != null){
			map.put("code", "200");
			map.put("user", user);
			return map;
		}
		map.put("code", "404");
		return map;
	}
	@RequestMapping("/logout")
	public Object logout(HttpSession session){
		session.invalidate();
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("code", "200");
		return map;
	}
	@RequestMapping("/updatePwd")
	public Object updatePwd(@RequestParam("id") Integer id,@RequestParam("password") String password){
		userService.updateUserById(id, password);
		return "200";
	}
	@RequestMapping("/getUserById")
	public Object getUserById(@RequestParam("id") Integer id){
		User user = userService.getUserById(id);
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("code", "200");
		map.put("data", user);
		return map;
	}
	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable("id") int id){
		userService.delete(id);
		return "删除成功";
	}
	@RequestMapping("/add")
	public String add(User user){
		userService.addUser(user);
		return "添加成功";
	}
	@RequestMapping("/edit/{id}")
	public User getById(@PathVariable("id") Integer id){
		User user = userService.getById(id);
		return user;
	}
	@RequestMapping("/update")
	public String update(User user){
		userService.update(user);
		return "修改成功";
	}
	@RequestMapping("/getUsers")
	public Object getUsers(@RequestParam("currentPage") int currentPage,@RequestParam("pageSize") int pageSize,@RequestParam("searchName") String searchName){
		if(searchName == null || "".equals(searchName)){
			searchName = "%%";
		}else{
			searchName = "%"+searchName+"%";
		}
		
		List<User> list = userService.getUsers(currentPage, pageSize, searchName);
		int count = userService.getUserCount(searchName);
		//计算总页数
		int countPage = count%pageSize==0?count/pageSize:(count/pageSize)+1;
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("code", "200");
		map.put("data", list);
		map.put("countPage", countPage);
		return map;
	}
}
