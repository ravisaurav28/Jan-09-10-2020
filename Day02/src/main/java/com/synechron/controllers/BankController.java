package com.synechron.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.synechron.services.AccountService;

@RestController
@RequestMapping("/bank")
public class BankController {
	
	@Autowired
	private AccountService accountService;
	
	@PostMapping("/deposit")
	public String deposit(@RequestParam("accountnumber") int accountNumber, @RequestParam int amount, @RequestParam String type) {
		accountService.deposit(accountNumber, amount, type);
		return "Deposited successfully";
	}
	
	@PostMapping("/withdraw")
	public String withdraw(@RequestParam("accountnumber") int accountNumber, @RequestParam int amount, @RequestParam String type) {
		accountService.withdraw(accountNumber, amount, type);
		return "Withdrawn successfully";
	}
}
