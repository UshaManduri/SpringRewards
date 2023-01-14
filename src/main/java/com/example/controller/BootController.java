package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.service.RewardsService;

@RestController
public class BootController {


	@Autowired
	RewardsService rewardsService;
	
	
	//http://localhost:9090/calculaterewards?amount=101
	@GetMapping("calculaterewards")
	public Object calculaterewards(String CustomerId, @RequestParam(name = "amount") Float amount) {
		try {
			return rewardsService.getRewards(amount);
		}catch(Exception e) {
			return HttpStatus.NOT_FOUND;
		}
	}
	 
}