package com.hristov.album.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

	@RequestMapping(value="public/{accountNumber}")
	public String getPublicAccount(@PathVariable final int accountNumber){
		return "Public Account Linked To: " + accountNumber;
	}
	
	@RequestMapping(value="admin/{accountNumber}")
	public String getAdminAccount(@PathVariable final int accountNumber){
		return "Admin Account Linked To: " + accountNumber;
	}
	
}
