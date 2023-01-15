package com.example.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.example.model.RewardsResponse;

@Service
public class RewardsService {

	static final float ONE_POINT_LIMIT = 50;
	static final float TWO_POINT_LIMIT = 100;
	
	Logger logger = LoggerFactory.getLogger(RewardsService.class);

	public RewardsResponse getRewards(float amount) {

		try {

			RewardsResponse rewardsResponse = new RewardsResponse();

			float onePointRewards = 0;
			float twoPointRewards = 0;

			if (amount > TWO_POINT_LIMIT) {
				twoPointRewards = (amount - 100) * 2;
				logger.info("1 point rewards " + onePointRewards + " Two point rewards " + twoPointRewards);

				onePointRewards = 50;

			}

			if (amount > ONE_POINT_LIMIT & amount <= TWO_POINT_LIMIT) {
				onePointRewards = amount - 50;
				twoPointRewards = 0;
				logger.info("1 point rewards " + onePointRewards + " Two point rewards " + twoPointRewards);

			}

			rewardsResponse.setOnePointRewards(onePointRewards);
			rewardsResponse.setTwoPointRewards(twoPointRewards);
			rewardsResponse.setTotalRewards(onePointRewards + twoPointRewards);

			return rewardsResponse;
		} catch (Exception e) {
				
				logger.error("Error at RewardsService : getRewards"+ e.getMessage());
		}
		
		return null;
				
	}

}
