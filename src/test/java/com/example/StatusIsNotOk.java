package com.example;

import org.springframework.http.HttpStatus;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultMatcher;

public class StatusIsNotOk implements ResultMatcher{
	
	private static StatusIsNotOk statusIsNotOk;
	
	private StatusIsNotOk() {
		
	}

	@Override
	public void match(MvcResult result) throws Exception {
		if(result.getResponse().getStatus() == HttpStatus.OK.value()) {
			throw new Exception("Status is OK");
		}
		
	}
	
	public static ResultMatcher statusNotOk() {
		if(statusIsNotOk == null) {
			statusIsNotOk = new StatusIsNotOk();
		}
		
		return statusIsNotOk;
	}

	
}
