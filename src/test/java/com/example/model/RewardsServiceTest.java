package com.example.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.Assertions;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.service.RewardsService;

@ExtendWith(SpringExtension.class)
public class RewardsServiceTest {
	
	@InjectMocks
	RewardsService rewardsService;

	@Test
	public void testGetRewards() {
		RewardsResponse rewardsResponse = rewardsService.getRewards(120f);
		
		Assertions.assertEquals(50.0f, rewardsResponse.getOnePointRewards());
		Assertions.assertEquals(40.0f, rewardsResponse.getTwoPointRewards());
		Assertions.assertEquals(90.0f, rewardsResponse.getTotalRewards());
	}
}
