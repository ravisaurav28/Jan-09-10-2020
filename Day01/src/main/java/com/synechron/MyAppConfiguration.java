package com.synechron;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyAppConfiguration {

	@Bean
	public List<String> lunchOptions() {
		return Arrays.asList("Chinese", "North Indian", "South Indian");
	}
	
}
