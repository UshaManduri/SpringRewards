package com.example.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Getter
@Setter
@Slf4j
public class RewardsResponse {
	
	private Float onePointRewards;
	private Float twoPointRewards;
	private Float totalRewards;
	
	public Float getOnePointRewards() {
		return onePointRewards;
	}
	public void setOnePointRewards(Float onePointRewards) {
		this.onePointRewards = onePointRewards;
	}
	public Float getTwoPointRewards() {
		return twoPointRewards;
	}
	public void setTwoPointRewards(Float twoPointRewards) {
		this.twoPointRewards = twoPointRewards;
	}
	public Float getTotalRewards() {
		return totalRewards;
	}
	public void setTotalRewards(Float totalRewards) {
		this.totalRewards = totalRewards;
	}
	
	

}
