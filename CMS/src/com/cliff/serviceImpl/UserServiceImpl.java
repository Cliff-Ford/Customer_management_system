package com.cliff.serviceImpl;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cliff.dao.UserMapper;
import com.cliff.pojo.User;
import com.cliff.service.UserService;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService{

	@Autowired
	private UserMapper userMapper;
	
	@Override
	public User findUser(User t) {		
		User user = this.userMapper.findUser(t);
		System.out.println(user);
		return user;
	}
	
	
	
}
