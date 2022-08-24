package com.orderservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orderservice.entity.User;
import com.orderservice.repository.UserRepo;

@Service
public class UserService {

	
	@Autowired
	UserRepo userRepo;
	
	public void saveUser(User user) {
		userRepo.save(user); 
	}

	public List<User> getAllUser() {
		return userRepo.findAll();
	}

//	public void updateUser(int id) {
//		// TODO Auto-generated method stub
//		
//	}
}
