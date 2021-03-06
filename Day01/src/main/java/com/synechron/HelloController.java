package com.synechron;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

	//http://localhost:8080/greet?name=Ram
	@PostMapping("/greet")
	@ResponseBody
	public String greet(@RequestParam("name") String name) {
		return "How are you " + name; 
	}
	
	//http://localhost:8080/bye/Sam
	@GetMapping("/bye/{name}")
	@ResponseBody
	public String bye(@PathVariable("name") String name) {
		return "Bye Bye " + name;
	}
	
	
	@GetMapping("/hello")
	@ResponseBody
	public String hi() {
		return "Hello";
	}
}
