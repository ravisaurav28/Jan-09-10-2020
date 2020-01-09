package com.synechron;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

//@RestController = @Controller + @ResponseBody

@Controller
public class TrainingController {

	@PostMapping("/register")
	public String registerForTraining(@RequestParam("firstname") String firstName
			, HttpSession session) {
		String message = "Hi " + firstName + "! Registration successful";
		session.setAttribute("message", message);
		return "result";
	}
}
