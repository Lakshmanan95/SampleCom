package com.cloubiot.buddyWAPI.dao;

import org.springframework.data.repository.CrudRepository;

import com.cloubiot.buddyWAPI.model.dbentity.User;

public interface UserRepository extends CrudRepository<User, String>{

	User findByUserNameAndPassword(String userName, String password);
	User findByEmail(String email);
}
