package com.stock.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stock.entity.UserEntity;
import com.stock.exception.UserAlreadyExistsException;
import com.stock.repo.userrepo;

@Service
public class UserServiceimpl implements IuserService {

	@Autowired
	userrepo repo;

	@Override
	public UserEntity registeruser(UserEntity user) {
		if(repo.existsById(user.getId()))
		{
			throw new UserAlreadyExistsException();
		}
		else
		{ repo.save(user);
		return user;}
	}

	@Override
	public String loginuser(String username,String password) {
		
		Optional<UserEntity> user=Optional.ofNullable(repo.findByUsername(username));
		if(user.get().getConfirmed()==true) {
		System.out.println(repo.findByUsername(username));
		if(repo.existsById(repo.findByUsername(username).getId()))
		{
			System.out.println("Found");
			if(password.equals(user.get().getPassword()))
			{
				System.out.println("Found");
				return "Login successful";
			}
			return "Wrong password";
		}
		else 
			return "User not found, Register user";
		
	}
		return null;}
	


	@Override
	public String updatePassword(String username, String oldpwd, String newpwd) {
		Optional<UserEntity> user=Optional.ofNullable(repo.findByUsername(username));
		if(repo.existsById(repo.findByUsername(username).getId()))
		{
			if(oldpwd.equals(user.get().getPassword()))
			{
				Optional<UserEntity> user1= Optional.ofNullable(repo.findByUsername(username));
				user1.get().setPassword(newpwd);
				return "password updated";
			}
			return "Wrong old password";
		}
		else 
			return "username or password wrong";
		
	}

	@Override
	public String deleteUser(UserEntity user) {
//		if(repo.existsById(user.getId()))
//		{
//			repo.delete(user);
//			return "deleted";
//			}
//		return "Couldnt delele user";
		repo.delete(user);
		return "deleted";
				
	}


}
