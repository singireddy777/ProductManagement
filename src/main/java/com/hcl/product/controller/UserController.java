package com.hcl.product.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.product.dto.UserDTO;
import com.hcl.product.service.UserService;

@RestController
public class UserController {
	
	private static final Logger logger= LoggerFactory.getLogger(UserController.class);
			
	@Autowired UserService userService;
	@PostMapping("/userRegistration")
	public String userRegistration(@RequestBody UserDTO userDTO) {
		
		logger.info("inside the userRegistration...");
		return userService.saveUser(userDTO);

	}
	
	@PostMapping("/userLogin")
	public String userLogin(@RequestParam("userName") String userName , @RequestParam("password") String password) {

		return userService.loginUser(userName, password);
}
	
}
