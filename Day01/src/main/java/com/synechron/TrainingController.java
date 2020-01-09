package com.synechron;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

//@RestController = @Controller + @ResponseBody

@Controller
public class TrainingController {

	@PostMapping("/register")
	public String registerForTraining(@RequestParam("firstname") String firstName) {
		String message = "Hi " + firstName + "! Registration successful";
		return "result";
	}
}
