package com.cloubiot.buddyWAPI.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloubiot.buddyWAPI.dao.UserRepository;
import com.cloubiot.buddyWAPI.model.dbentity.User;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	
	public User saveUser(User user) {
		return userRepository.save(user);
	}
	
	public User accessLogin(String userName, String password) {
		return userRepository.findByUserNameAndPassword(userName, password);
	}
	
	public User emailIdExists(String email) {
		return userRepository.findByEmail(email);
	}
	
}
