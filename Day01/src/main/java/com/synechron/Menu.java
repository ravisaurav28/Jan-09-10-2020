package com.synechron;

import java.util.Arrays;
import java.util.List;

public class Menu {
	private List<String> menuItems = Arrays.asList("Roti", "Rice", "Sandwich");

	public List<String> getMenuItems() {
		return menuItems;
	}

	public void setMenuItems(List<String> menuItems) {
		this.menuItems = menuItems;
	}
	
}
