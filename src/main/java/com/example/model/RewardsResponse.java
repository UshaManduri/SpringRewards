package com.example.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Getter
@Setter
@Slf4j
public class RewardsResponse {
	
	private float onePointRewards;
	private float twoPointRewards;
	private float totalRewards;
	public float getOnePointRewards() {
		return onePointRewards;
	}
	public void setOnePointRewards(float onePointRewards) {
		this.onePointRewards = onePointRewards;
	}
	public float getTwoPointRewards() {
		return twoPointRewards;
	}
	public void setTwoPointRewards(float twoPointRewards) {
		this.twoPointRewards = twoPointRewards;
	}
	public float getTotalRewards() {
		return totalRewards;
	}
	public void setTotalRewards(float totalRewards) {
		this.totalRewards = totalRewards;
	}
	
	
	
	

}
