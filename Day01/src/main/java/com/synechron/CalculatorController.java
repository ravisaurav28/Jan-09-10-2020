package com.synechron;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calc")
public class CalculatorController {

	@Autowired
	private Calculator calculator;
	
	@PostMapping("/product")
	public int product(@RequestParam int num1, @RequestParam int num2) {
		return calculator.multiply(num1, num2);
	}
	
	@PutMapping("/subtract/{a}/{b}")
	public int subtract(@PathVariable int a, @PathVariable int b) {
		return calculator.subtract(a, b);
	}
	
	@GetMapping("/square/{a}")
	public int square(@PathVariable int a) {
		return calculator.square(a);
	}
	
	@GetMapping("/add/{a}/{b}")
	public int sum(@PathVariable int a, @PathVariable int b) {
		return calculator.add(a, b);
	}
	
	
	
	
}
