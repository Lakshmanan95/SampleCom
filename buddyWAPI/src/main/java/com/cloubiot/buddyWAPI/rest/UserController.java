package com.cloubiot.buddyWAPI.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cloubiot.buddyWAPI.base.SuccessResponse;
import com.cloubiot.buddyWAPI.common.CloubiotLogging;
import com.cloubiot.buddyWAPI.model.dbentity.User;
import com.cloubiot.buddyWAPI.model.user.ExistsValueRequest;
import com.cloubiot.buddyWAPI.model.user.LoginRequest;
import com.cloubiot.buddyWAPI.model.user.UserResponse;
import com.cloubiot.buddyWAPI.service.UserService;
import com.cloubiot.buddyWAPI.util.JSONUtil;
import com.cloubiot.buddyWAPI.util.SecureData;

@RestController
@RequestMapping("user")
public class UserController {

	@Autowired
	UserService userService;
	
	@RequestMapping(method = RequestMethod.POST, value="/addUpdateUser")
	public SuccessResponse addUpdateUser(@RequestBody User request) {
		SuccessResponse response = new SuccessResponse();
		try {
			if(request.getFirstName() != null && request.getLanguageId() != null && request.getLastName() != null 
					&& request.getUserName() != null && request.getEmail() != null) {
				SecureData sd = new SecureData();
				String encryptedPassword = sd.encrypt(request.getPassword());
				request.setPassword(encryptedPassword);
				userService.saveUser(request);
			}
			else {
				response.setSuccess(false);
				response.setStatusMessage("Invalid Data");
			}
			CloubiotLogging.logInfo(getClass(), "Add Update User");
		}
		catch(Exception e) {
			response.setSuccess(false);
			CloubiotLogging.logError(getClass(), "AddUpdate User Fails", e);
		}
		return response;
	}
	
	@RequestMapping(method = RequestMethod.POST, value="/login")
	public UserResponse accessLogin(@RequestBody LoginRequest request) {
		UserResponse response = new UserResponse();
		try {
			SecureData sd = new SecureData();
			String decryptPassword = sd.encrypt(request.getPassword());
			User user = userService.accessLogin(request.getUserName(), decryptPassword);
			System.out.println("User "+JSONUtil.toJson(user));
			if(user == null) {
				response.setSuccess(false);
				response.setStatusMessage("Login Failed");
			}
			CloubiotLogging.logInfo(getClass(), "Login Success");
		}
		catch(Exception e) {
			response.setSuccess(false);
			CloubiotLogging.logError(getClass(), "Login Fails", e);			
		}
		return response;
	}
	
	@RequestMapping(method = RequestMethod.POST, value="/emailExists")
	public SuccessResponse emailExists(@RequestBody ExistsValueRequest request) {
		SuccessResponse response = new SuccessResponse();
		try {
			User user = userService.emailIdExists(request.getEmail());
			if(user == null) {
				response.setSuccess(false);
				response.setStatusMessage("Email Not Exist");
			}
			else
				response.setStatusMessage("Email Exists");
			CloubiotLogging.logInfo(getClass(), "Email Exists");	
		}
		catch(Exception e) {
			response.setSuccess(false);
			CloubiotLogging.logError(getClass(), "Email Exists Fails", e);			
		}
		return response;
	}
	
}
