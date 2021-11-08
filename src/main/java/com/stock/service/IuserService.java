package com.stock.service;

import org.springframework.stereotype.Service;

import com.stock.entity.UserEntity;

@Service
public interface IuserService {
	
	
	public UserEntity registeruser(UserEntity user);
	public String loginuser(String username,String password);
	public String updatePassword(String username, String oldpwd, String newpwd);
	public String deleteUser(UserEntity user);

}
