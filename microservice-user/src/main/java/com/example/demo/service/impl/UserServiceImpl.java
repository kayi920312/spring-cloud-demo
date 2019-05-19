package com.example.demo.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.example.demo.bean.User;
import com.example.demo.dao.UserRepository;
import com.example.demo.service.UserService;

@Service("UserServiceImpl")
public class UserServiceImpl implements UserService {
	
	@Resource(name = "UserRepository")
	private UserRepository userDao;

	@Override
	public List<User> getUserList(User user) {
		Example<User> param = Example.of(user);
		return userDao.findAll(param);
		
	}
	
	
}
