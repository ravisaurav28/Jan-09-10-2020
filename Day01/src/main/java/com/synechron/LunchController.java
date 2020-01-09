package com.synechron;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LunchController {

	@Value("${lunch.message}")
	private String welcome;
	
	@Autowired
	private List<String> lunchOptions;
	
	@GetMapping("/lunch/welcome")
	public String getWelcomeMessage() {
		return welcome;
	}
	
	
	@GetMapping("/lunch")
	public List<String> getMenuItems() {
		List<String> menuItems = Arrays.asList("Roti", "Rice", "Sandwich");
		return menuItems;
	}
	
	@GetMapping("/menu")
	public Menu getMenu() {
		return new Menu();
	}
}
