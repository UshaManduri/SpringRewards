package com.example.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyFloat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.example.model.RewardsResponse;
import com.example.service.RewardsService;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith(SpringExtension.class)
@WebMvcTest(value = BootController.class)
public class BootControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private RewardsService rewardsService;
	
	private ObjectMapper objectMapper = new ObjectMapper();
	
	private RewardsResponse rewardsResponse;
	
	@BeforeEach
	public void setUp() throws JsonParseException, JsonMappingException, IOException {
		rewardsResponse = objectMapper.readValue(
				new File(getClass().getClassLoader().getResource("rewardsResponse.json").getFile()), 
				new TypeReference<RewardsResponse>() {});
	}
	
	@Test
	public void testGetCalculateRewards() throws UnsupportedEncodingException, Exception {
		
		when(rewardsService.getRewards(anyFloat())).thenReturn(rewardsResponse);
		
		String responseAsString = mockMvc.perform(get("/calculaterewards?amount=101"))
				.andExpect(status().isOk())
				.andReturn().getResponse().getContentAsString();
		
		RewardsResponse rewardsResponse = objectMapper.readValue(responseAsString, new TypeReference<RewardsResponse>() {});
		
		assertThat(rewardsResponse).isNotNull();
		
		Assertions.assertEquals(50.0f, rewardsResponse.getOnePointRewards());
		Assertions.assertEquals(2.0f, rewardsResponse.getTwoPointRewards());
		Assertions.assertEquals(52.0f, rewardsResponse.getTotalRewards());
	}
	
}
