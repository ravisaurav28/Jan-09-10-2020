package com.synechron;

import org.springframework.stereotype.Component;

@Component
public class Calculator {
	
	public int add(int number1, int number2) {
		return number1 + number2;
	}
	
	public int subtract(int number1, int number2) {
		return number1 - number2;
	}
	
	public int multiply(int number1, int number2) {
		return number1 * number2;
	}
	
	public int square(int number) {
		return number * number;
	}
	
}
